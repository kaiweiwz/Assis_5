package com.example.assis_3.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.util.Log;

import com.example.assis_3.DaoSession;
import com.example.assis_3.SystemConfig;
import com.example.assis_3.SystemConfigDao.Properties;
import com.example.assis_3.app.AppApplication;

public class SystemConfigManager {
	
	private static final String TAG = "Test";

	private static final SystemConfigManager instance = new SystemConfigManager();

	private static final Map<String, String> configMap = new HashMap<String, String>();

	public static SystemConfigManager getInstance() {
		return instance;
	};

	public Map<String, String> getConfig() {
		initConfig();
		return configMap;
	}

	public void initConfig() {
		// 从库中取值， 存入Map
		List<SystemConfig> list = AppApplication.getDaoSession().loadAll(
				SystemConfig.class);
		for (int i = 0; i < list.size(); i++) {
			SystemConfig systemConfig = list.get(i);
			configMap.put(systemConfig.getConfigName(),
					systemConfig.getConfigValue());
		}
	}

	public void saveConfig(Map<String, String> map){
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()){
			String configName = iter.next();
			if(map.get(configName).equals(configMap.get(configName))){
				continue;
			}else{
				configMap.put(configName, map.get(configName));
			}
		}
		//Dao.save
		Iterator<String> iterator = configMap.keySet().iterator();
		DaoSession daoSession = AppApplication.getDaoSession();
		while(iterator.hasNext()){
			SystemConfig config = new SystemConfig();
			config.setConfigName(iterator.next());
			config.setConfigValue(configMap.get(config.getConfigName()));
			Long id = daoSession.queryBuilder(SystemConfig.class).where(Properties.ConfigName.eq(config.getConfigName())).list().get(0).getId();
			config.setId(id);
			daoSession.update(config);
			Log.i(TAG, "config is update : " + config.toString());
		}
	}
}