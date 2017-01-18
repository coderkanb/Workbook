package com.kb.workbook.activity.mall;

import android.os.Bundle;
import android.view.View;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;

public class MallActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_mall;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void onTextView(View view) {
        startActivity(TextViewActivity.class);
    }

    public void toJavaTest(View view) {
        startActivity(JavaTestActivity.class);
    }
}
