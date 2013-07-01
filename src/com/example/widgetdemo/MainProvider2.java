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

public class MainProvider2 extends AppWidgetProvider {

	 /** Called when the activity is first created. */  

    @Override  
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,  
            int[] appWidgetIds) {  
		for(int i= 0;i<appWidgetIds.length;i++){
			System.out.println(appWidgetIds[i]);
			Intent intent = new Intent(context,TestActivity.class);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,2); 
			
			PendingIntent pendingIntent = PendingIntent.getActivity(
					context, appWidgetIds[i], intent, PendingIntent.FLAG_UPDATE_CURRENT);
			
			RemoteViews remoteViews  = new RemoteViews(context.getPackageName(), R.layout.main);
			remoteViews.setOnClickPendingIntent(R.id.wordcup, pendingIntent);
			appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
		}
        
        super.onUpdate(context, appWidgetManager, appWidgetIds);  
    }  


    private class MyTime extends TimerTask{  
        RemoteViews remoteViews;  
        AppWidgetManager appWidgetManager;  
        ComponentName thisWidget;  

        public MyTime(Context context,AppWidgetManager appWidgetManager){  
            this.appWidgetManager = appWidgetManager;  
            remoteViews = new RemoteViews(context.getPackageName(),R.layout.main);  

            thisWidget = new ComponentName(context,MainProvider2.class);  
        }  
        public void run() {  

            Date date = new Date();  
            Calendar calendar = new GregorianCalendar(2010,06,11);  
            long days = (((calendar.getTimeInMillis()-date.getTime())/1000))/86400;  
            remoteViews.setTextViewText(R.id.wordcup, "距离南非世界杯还有" + days+"天");  
            appWidgetManager.updateAppWidget(thisWidget, remoteViews);  

        }  

    }  

}
