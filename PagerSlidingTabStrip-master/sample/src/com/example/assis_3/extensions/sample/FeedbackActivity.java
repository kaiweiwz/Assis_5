package com.example.assis_3.extensions.sample;

import java.util.ArrayList;
import java.util.List;

import com.example.assis_3.FeedbackMsg;
import com.example.assis_3.R;
import com.example.assis_3.adapter.FeedbackAdapter;
import com.example.assis_3.manager.FeedbackManager;
import com.example.assis_3.util.BaseTools;
import com.example.assis_3.util.DateTools;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class FeedbackActivity extends Activity implements OnClickListener {

	private ListView mListView;
	private FeedbackAdapter mFeedbackAdapter;
	private List<FeedbackMsg> feedbackList;
	
	private EditText bd_fb_et_sendmessage;
	private Button bd_fb_btn_send;
	
	/**
	 * Header
	 */
	private TextView fb_sendtime;
	private TextView fb_chatcontent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baidu_fb_main_layout);
		initActionBar();
		initView();
		initDate();
		initListener();
	}

	private void initListener() {
		bd_fb_btn_send.setOnClickListener(this);
	}

	private void initDate() {
		String nowDate = DateTools.getStrTime_ymd_hms();
		fb_sendtime.setText(nowDate);
		fb_chatcontent.setText(R.string.feedback_left_msg_1);
		feedbackList = FeedbackManager.getFeedbackManager().getSystemMsgAll();
		mFeedbackAdapter = new FeedbackAdapter(this, feedbackList);
		mListView.setAdapter(mFeedbackAdapter);
	}

	private void initView() {
		mListView = (ListView) this.findViewById(R.id.bd_fb_listview);
		fb_sendtime = (TextView) this.findViewById(R.id.fb_sendtime);
		fb_chatcontent = (TextView) this.findViewById(R.id.fb_chatcontent);
		bd_fb_et_sendmessage = (EditText) this.findViewById(R.id.bd_fb_et_sendmessage);
		bd_fb_btn_send = (Button) this.findViewById(R.id.bd_fb_btn_send);
	}

	private void initActionBar() {
		String title = getResources().getString(
				R.string.left_drawer_item_feedback);
		getActionBar().setTitle(title);
		// getActionBar().setLogo(R.drawable.btn_back_normal);
		int color = Color.parseColor("#FFC74B46");
		Drawable colorDrawable = new ColorDrawable(color);
		getActionBar().setBackgroundDrawable(colorDrawable);
		getActionBar().setDisplayShowTitleEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			FeedbackActivity.this.finish();
			startActivity(new Intent(this, MainActivity.class));
			overridePendingTransition(R.anim.slide_in_left,
					R.anim.slide_out_right);
			return true;
		default:
			return true;
		}
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.bd_fb_btn_send:
			String sendMsg = bd_fb_et_sendmessage.getText().toString();
			String nowDate = DateTools.getStrTime_ymd_hms();
			String phoneModel = "phone: " + Build.MODEL + ", version: " + Build.VERSION.RELEASE;
			FeedbackMsg msg = new FeedbackMsg();
			msg.setDate(nowDate);
			msg.setDescr(sendMsg);
			msg.setPhoneModel(phoneModel);
			feedbackList.add(msg);
            FeedbackManager.getFeedbackManager().insertRecord(msg);	
            mFeedbackAdapter.notifyDataSetChanged();
			mListView.invalidate();
			BaseTools.closeBoard(this);
			break;
		default:
			break;
		}

	}
}
