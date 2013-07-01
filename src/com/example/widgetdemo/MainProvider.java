package com.example.widgetdemo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimerTask;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class MainProvider extends AppWidgetProvider {

	/** Called when the activity is first created. */

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {

		// Timer timer = new Timer();
		// timer.scheduleAtFixedRate(new MyTime(context,appWidgetManager), 1,
		// 60000);

		//
		// RemoteViews rv = new RemoteViews(context.getPackageName(),
		// R.layout.main);
		// Intent intentClick = new Intent(context,TestActivity.class);
		// PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
		// intentClick, 0);
		// rv.setOnClickPendingIntent(R.id.wordcup, pendingIntent);
		//
		//
		// appWidgetManager.updateAppWidget(appWidgetIds[0], rv);

		for (int i = 0; i < appWidgetIds.length; i++) {
			System.out.println(appWidgetIds[i]);
			Intent intent = new Intent(context, TestActivity.class);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, 1);

			PendingIntent pendingIntent = PendingIntent.getActivity(context, appWidgetIds[i],
					intent, PendingIntent.FLAG_UPDATE_CURRENT);
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
					R.layout.main);
			remoteViews.setOnClickPendingIntent(R.id.wordcup, pendingIntent);
			appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
		}

		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}


}
