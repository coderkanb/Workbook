package com.kb.mallpractice.activity.bookdevart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.mallpractice.BaseActivity;
import com.kb.mallpractice.R;
import com.kb.mallpractice.utils.LogUtils;

public class AActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_a;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void openB(View view) {
        startActivity(BActivity.class);
        LogUtils.d(TAG, "[test log search]BActivity  //控制台搜索关键词XXX，只要log中包含XXX就显示");
    }
}
