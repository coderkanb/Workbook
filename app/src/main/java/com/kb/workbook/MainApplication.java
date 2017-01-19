package com.kb.workbook;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2016/10/31.
 */
public class MainApplication extends Application {

    public static String APP_NAME ;
    public static boolean isDebug;
    public static Context sContext;
    private static MainApplication instance;
    private Object data;

    @Override
    public void onCreate() {
        super.onCreate();
        APP_NAME = getResources().getString(R.string.app_name);
        sContext = getApplicationContext();

        isDebug = true;
        Fresco.initialize(this);
        LeakCanary.install(this);
    }

    public static Context getContext() {
        return sContext;
    }

    public static MainApplication getInstance() {
        return instance;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
