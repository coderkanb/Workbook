package com.kb.workbook.activity.idea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;

public class IdeaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_idea;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void toRefresh(View view) {
        startActivity(RefreshActivity.class);
    }
}
