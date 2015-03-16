package com.example.assis_3.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class BaseTools {

	/** 获取屏幕的宽度 */
	public final static int getWindowsWidth(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
	}

	public static void closeBoard(Context mcontext) {
		InputMethodManager imm = (InputMethodManager) mcontext
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		// imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
		if (imm.isActive()) { // 一直是true
			imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	public static void hideSystemKeyBoard(Context mcontext, View v) {
		InputMethodManager imm = (InputMethodManager) (mcontext
				.getSystemService(Context.INPUT_METHOD_SERVICE));
		imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
	}

}
