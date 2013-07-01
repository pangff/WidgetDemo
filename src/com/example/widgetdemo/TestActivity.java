package com.example.widgetdemo;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		
		
		Intent intent = getIntent();
		Log.e("ARC", ""+intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, -1));
		Bundle extras = intent.getExtras();
		int mAppWidgetId = 0;
		if (extras != null) {
			mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
		}
		if(mAppWidgetId == 1){
			Toast.makeText(this, "第一个", Toast.LENGTH_SHORT).show();
		}else if(mAppWidgetId == 2){
			Toast.makeText(this, "第二个", Toast.LENGTH_SHORT).show();
		}
	
	}
	
}
