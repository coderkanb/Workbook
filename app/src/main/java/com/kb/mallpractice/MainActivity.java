package com.kb.mallpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.mallpractice.activity.FrescoActivity;
import com.kb.mallpractice.activity.HomeActivity;
import com.kb.mallpractice.activity.ImageTestActivity;
import com.kb.mallpractice.activity.PicSelectActivity;
import com.kb.mallpractice.activity.TestActivity;
import com.kb.mallpractice.widget.LoadingDialog;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


}
