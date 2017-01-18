package com.kb.workbook.activity.baseframe;

import android.os.Bundle;
import android.view.View;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;

public class FrameworkActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framework);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_framework;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void onToast(View view) {
        startActivity(ToastActivity.class);
    }
}
