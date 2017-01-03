package com.kb.mallpractice.activity.bookdevart;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kb.mallpractice.R;
import com.kb.mallpractice.utils.LogUtils;

public class ActivityLifeActivity extends AppCompatActivity {
    public static final String TAG = ActivityLifeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_life);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.d(TAG, "[onSaveInstanceState]");
        outState.putString("test", "Hello world!");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtils.d(TAG, "[onRestoreInstanceState]");
        LogUtils.d(TAG, "[onRestoreInstanceState] test: " + savedInstanceState.getString("test"));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtils.d(TAG, "[onConfigurationChanged]");
    }
}
