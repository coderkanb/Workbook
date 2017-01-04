package com.kb.mallpractice.activity.baseframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.mallpractice.BaseActivity;
import com.kb.mallpractice.R;

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
