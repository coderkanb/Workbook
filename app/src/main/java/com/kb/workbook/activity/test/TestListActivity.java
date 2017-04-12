package com.kb.workbook.activity.test;

import android.os.Bundle;
import android.view.View;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;

public class TestListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_test_list;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void toGson(View view) {
        startActivity(GsonActivity.class);
    }

    public void leakMemory1(View view) {
        startActivity(LeakMemoryActivity.class);
    }

    public void leakMemory2(View view) {
        startActivity(LeakActivity.class);
    }

    public void toast2(View view) {
        startActivity(Toast2Activity.class);
    }
}
