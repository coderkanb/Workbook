package com.kb.workbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kb.workbook.activity.AnimActivity;
import com.kb.workbook.activity.baseframe.FrameworkActivity;
import com.kb.workbook.activity.bookdevart.BookDevArtActivity;
import com.kb.workbook.activity.FrescoActivity;
import com.kb.workbook.activity.HomeActivity;
import com.kb.workbook.activity.ImageTestActivity;
import com.kb.workbook.test.LeakMemoryActivity;
import com.kb.workbook.activity.PicSelectActivity;
import com.kb.workbook.activity.TaskActivity;
import com.kb.workbook.activity.TestActivity;
import com.kb.workbook.activity.idea.IdeaActivity;
import com.kb.workbook.activity.interview.InterviewContentActivity;
import com.kb.workbook.activity.mall.MallActivity;
import com.kb.workbook.activity.test.TestListActivity;

public class MainActivity extends BaseActivity {

    private Button mBtnBaseFramework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setupView();

    }

    private void initView() {
        mBtnBaseFramework = (Button) findViewById(R.id.btn_base_frame);
    }

    private void setupView() {
        mBtnBaseFramework.setOnClickListener(this);
    }

    @Override
    public void initParams(Bundle params) {
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn_base_frame: // 基础框架页
                startActivity(FrameworkActivity.class);
                break;
        }
    }

    public void toTest(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    public void toImageTest(View view){
        startActivity(ImageTestActivity.class);
    }


    public void toFresco(View view){
        startActivity(FrescoActivity.class);
    }

    public void toHome(View view){
        startActivity(HomeActivity.class);
    }

    public void toPicSelect(View view){
        startActivity(PicSelectActivity.class);
    }


    public void toTask(View view) {
        startActivity(TaskActivity.class);
    }

    public void toAnim(View view) {
        startActivity(AnimActivity.class);
    }

    public void toBook2(View view) {
        startActivity(BookDevArtActivity.class);
    }

    public void toMall(View view) {
        startActivity(MallActivity.class);
    }

    public void toInterview(View view) {
        startActivity(InterviewContentActivity.class);
    }

    public void toIdea(View view) {
        startActivity(IdeaActivity.class);
    }

    public void toTestPart(View view) {
        startActivity(TestListActivity.class);
    }
}
