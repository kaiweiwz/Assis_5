package com.example.assis_3.adapter;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.f;
import com.example.assis_3.FeedbackMsg;
import com.example.assis_3.R;

public class FeedbackAdapter extends BaseAdapter {

	private Activity mActivity;

	private List<FeedbackMsg> feedbackMsgList;
	
	private LayoutInflater inflater;

	public FeedbackAdapter() {

	}

	public FeedbackAdapter(Activity mActivity, List<FeedbackMsg> list) {
		this.mActivity = mActivity;
		this.feedbackMsgList = list;
		inflater = LayoutInflater.from(mActivity);
	}

	@Override
	public int getCount() {
		return feedbackMsgList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return feedbackMsgList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int postion, View view, ViewGroup root) {
		ViewHolder viewHolder = null;
		if(view == null){
			viewHolder = new ViewHolder();
			view = inflater.inflate(R.layout.baidu_fb_chatting_item_msg_text_right, root, false);
			viewHolder.fb_chatcontent = (TextView) view.findViewById(R.id.fb_chatcontent);
			viewHolder.fb_sendtime = (TextView) view.findViewById(R.id.fb_sendtime);
			viewHolder.fb_userhead = (ImageView) view.findViewById(R.id.fb_userhead);
			view.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.fb_sendtime.setText(feedbackMsgList.get(postion).getDate());
		viewHolder.fb_chatcontent.setText(feedbackMsgList.get(postion).getDescr());
		return view;
	}

	static class ViewHolder {
		TextView fb_sendtime;
		TextView fb_chatcontent;
		ImageView fb_userhead;
	}

}