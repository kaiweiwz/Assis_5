package com.example.assis_3.manager;

import java.util.List;

import com.example.assis_3.DaoSession;
import com.example.assis_3.FeedbackMsg;
import com.example.assis_3.app.AppApplication;

public class FeedbackManager {
	public static final FeedbackManager instance = new FeedbackManager();

	public FeedbackManager() {
	}

	public static FeedbackManager getFeedbackManager() {
		return instance;
	}
	
	public void insertRecord(FeedbackMsg feedbackMsg){
		DaoSession daoSession = AppApplication.getDaoSession();
		daoSession.insert(feedbackMsg);
	}

	//
	public FeedbackMsg getSysMsgById(Long id) {
		DaoSession daoSession = AppApplication.getDaoSession();
		FeedbackMsg record = daoSession.getFeedbackMsgDao().loadByRowId(id);
		return record;
	}

	//
	public List<FeedbackMsg> getSystemMsgAll() {
		DaoSession daoSession = AppApplication.getDaoSession();
		List<FeedbackMsg> record = daoSession.getFeedbackMsgDao().loadAll();
		return record;
	}

	//
	public void deleteSystemMsgById(Long id) {
		DaoSession daoSession = AppApplication.getDaoSession();
		daoSession.getFeedbackMsgDao().deleteByKey(id);
	}
}