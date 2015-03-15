package com.example.assis_3.adapter;

import java.util.List;

import com.example.assis_3.R;
import com.example.assis_3.SystemMsg;
import com.example.assis_3.adapter.NewsAdapter.ViewHolder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MessageAdapter extends BaseExpandableListAdapter {

	private List<SystemMsg> msgList;
	private Activity mActivity;
	
	private LayoutInflater inflater = null;
	
	private ViewHolder mViewHolder_chiild;
	private ViewHolder mViewHolder_prarent;
	
	public MessageAdapter() {

	}

	public MessageAdapter(List<SystemMsg> msgList, Activity mActivity) {
		this.msgList = msgList;
		this.mActivity = mActivity;
		inflater = LayoutInflater.from(mActivity);
	}

	@Override
	public String getChild(int parentPosition, int childPosition) {
		return msgList.get(parentPosition).getDescr();
	}

	@Override
	public long getChildId(int parentPosition, int childPosition) {
		return parentPosition;
	}

	@Override
	public View getChildView(int parentPosition, int childPosition,
			boolean arg2, View convertView, ViewGroup root) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.expand_list_item, root, false);
			mViewHolder_chiild = new ViewHolder();
			mViewHolder_chiild.title = (TextView) convertView.findViewById(R.id.ex_item_title);
			mViewHolder_chiild.publishTime = (TextView) convertView.findViewById(R.id.ex_publish_time);
			mViewHolder_chiild.content = (TextView) convertView.findViewById(R.id.ex_item_abstract);
			convertView.setTag(mViewHolder_chiild);
		}else{
			mViewHolder_chiild = (ViewHolder) convertView.getTag();
		}
		String content = msgList.get(parentPosition).getDescr();
		mViewHolder_chiild.content.setText(content);
		mViewHolder_chiild.title.setVisibility(View.GONE);
		mViewHolder_chiild.publishTime.setVisibility(View.GONE);
		return convertView;
	}

	@Override
	public int getChildrenCount(int parentPosition) {
		// 点击标题，显示一条对应记录
		return 1;
	}

	@Override
	public String getGroup(int parentPosition) {
		return msgList.get(parentPosition).getTitle();
	}

	@Override
	public int getGroupCount() {
		return msgList.size();
	}

	@Override
	public long getGroupId(int parentPosition) {
		return parentPosition;
	}

	@Override
	public View getGroupView(int parentPosition, boolean childPosition,
			View convertView, ViewGroup viewRoot) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.expand_list_item, viewRoot, false);
			mViewHolder_prarent = new ViewHolder();
			mViewHolder_prarent.title = (TextView) convertView.findViewById(R.id.ex_item_title);
			mViewHolder_prarent.publishTime = (TextView) convertView.findViewById(R.id.ex_publish_time);
			mViewHolder_prarent.content = (TextView) convertView.findViewById(R.id.ex_item_abstract);
			convertView.setTag(mViewHolder_prarent);
		}else{
			mViewHolder_prarent = (ViewHolder) convertView.getTag();
		}
		String title = msgList.get(parentPosition).getTitle();
		String time = msgList.get(parentPosition).getTime();
		mViewHolder_prarent.publishTime.setVisibility(View.VISIBLE);
		mViewHolder_prarent.content.setVisibility(View.GONE);
		mViewHolder_prarent.title.setVisibility(View.VISIBLE);
		mViewHolder_prarent.title.setText(title);
		mViewHolder_prarent.publishTime.setText(time);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int parentPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}
	static class ViewHolder {
		TextView title;
		TextView publishTime;
		TextView content;
	}
}
