package com.kb.mallpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kb.mallpractice.activity.AnimActivity;
import com.kb.mallpractice.activity.baseframe.FrameworkActivity;
import com.kb.mallpractice.activity.bookdevart.BookDevArtActivity;
import com.kb.mallpractice.activity.FrescoActivity;
import com.kb.mallpractice.activity.HomeActivity;
import com.kb.mallpractice.activity.ImageTestActivity;
import com.kb.mallpractice.activity.LeakMemoryActivity;
import com.kb.mallpractice.activity.PicSelectActivity;
import com.kb.mallpractice.activity.TaskActivity;
import com.kb.mallpractice.activity.TestActivity;

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

    public void toLeakMemory(View view) {
        startActivity(LeakMemoryActivity.class);
    }

    public void toAnim(View view) {
        startActivity(AnimActivity.class);
    }

    public void toBook2(View view) {
        startActivity(BookDevArtActivity.class);
    }
}
