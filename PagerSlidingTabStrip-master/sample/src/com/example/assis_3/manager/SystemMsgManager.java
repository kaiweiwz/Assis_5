package com.example.assis_3.manager;

import java.util.List;

import android.app.Activity;

import com.example.assis_3.DaoSession;
import com.example.assis_3.SystemMsg;
import com.example.assis_3.app.AppApplication;

public class SystemMsgManager {

	public static final SystemMsgManager instance = new SystemMsgManager();

	public SystemMsgManager() {
	}

	public static SystemMsgManager getSystemMsgManager() {
		return instance;
	}

	//
	public SystemMsg getSysMsgById(Long id) {
		DaoSession daoSession = AppApplication.getDaoSession();
		SystemMsg record = daoSession.getSystemMsgDao().loadByRowId(id);
		return record;
	}

	//
	public List<SystemMsg> getSystemMsgAll() {
		DaoSession daoSession = AppApplication.getDaoSession();
		List<SystemMsg> record = daoSession.getSystemMsgDao().loadAll();
		return record;
	}

	//
	public void deleteSystemMsgById(Long id) {
		DaoSession daoSession = AppApplication.getDaoSession();
		daoSession.getSystemMsgDao().deleteByKey(id);
	}
}