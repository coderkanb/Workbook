package com.kb.workbook.activity.bookdevart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;
import com.kb.workbook.utils.LogUtils;

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
