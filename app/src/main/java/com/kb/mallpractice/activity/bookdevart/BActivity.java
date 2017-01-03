package com.kb.mallpractice.activity.bookdevart;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.mallpractice.BaseActivity;
import com.kb.mallpractice.R;
import com.kb.mallpractice.utils.LogUtils;

public class BActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        LogUtils.d(TAG, "[onCreate]");
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_b;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void openB(View view) {
        startActivity(BActivity.class);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.d(TAG, "[onNewIntent]");
    }
}
