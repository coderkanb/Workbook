package com.kb.workbook.activity.interview;

import android.os.Bundle;
import android.view.View;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;

/**
 * 《Android程序员面试宝典》目录
 */
public class InterviewContentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_content);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_interview_content;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void toChapter2(View view) {
        startActivity(Chapter2Activity.class);
    }
}
