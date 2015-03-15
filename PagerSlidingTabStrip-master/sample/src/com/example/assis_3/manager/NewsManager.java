package com.example.assis_3.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.database.SQLException;

import com.example.assis_3.DaoSession;
import com.example.assis_3.NewsEntity;
import com.example.assis_3.NewsEntityDao.Properties;
import com.example.assis_3.app.AppApplication;

public class NewsManager {
	public static NewsManager newsManager;

	public static Activity mActivity;

	/**
	 * 初始化频道管理类
	 * 
	 * @param paramDBHelper
	 * @throws SQLException
	 */
	public static NewsManager getManager(Activity activity)
			throws SQLException {
		mActivity = activity;
		if (newsManager == null) {
			newsManager = new NewsManager();
		}
		return newsManager;
	}

	public List<NewsEntity> getAllFavorNews() {
		DaoSession daoSession = AppApplication.getDaoSession();
		List<NewsEntity> favoriteNewsList = daoSession.getNewsEntityDao().loadAll();
		return favoriteNewsList;
	}
	
	public List<NewsEntity> isFavoriteNews(NewsEntity record){
		DaoSession daoSession = AppApplication.getDaoSession();
		List<NewsEntity> results = Collections.emptyList();
		results = daoSession.getNewsEntityDao().queryBuilder().where(Properties.Title.eq(record.getTitle())).list();
		return results;
	}
	
	public void insertFavoriteNews(NewsEntity record){
		DaoSession daoSession = AppApplication.getDaoSession();
		daoSession.insert(record);
	}
	
	public void deleteFavoriteNews(NewsEntity record){
		DaoSession daoSession = AppApplication.getDaoSession();
		Long id = daoSession.getNewsEntityDao().queryBuilder().where(Properties.Title.eq(record.getTitle())).list().get(0).getId();
		daoSession.getNewsEntityDao().deleteByKey(id);
	}
}