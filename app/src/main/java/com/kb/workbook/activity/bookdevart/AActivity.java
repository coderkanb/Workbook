package com.kb.workbook.activity.bookdevart;

import android.os.Bundle;
import android.view.View;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;
import com.kb.workbook.utils.LogUtils;

public class AActivity extends BaseActivity {
//    public static final String TAG = AActivity.class.getSimpleName();

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

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d(TAG, "onStop");
    }
}
