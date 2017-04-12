package com.kb.workbook.activity.mall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wang.avi.AVLoadingIndicatorView;
import com.kb.workbook.R;

public class LoadingActivity extends AppCompatActivity {

    private AVLoadingIndicatorView mAvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        mAvi = (AVLoadingIndicatorView) findViewById(R.id.loading_indicator);
//        mAvi.setIndicatorColor(R.color.app_orange);
        /**
         * 找到原因了，有bug，必须代码设置这个，颜色才显示正常
         */
        String indicator = "LineScaleIndicator";
        mAvi.setIndicator(indicator);
    }

    public void show(View view) {
//        mAvi.show();
        mAvi.smoothToShow();
    }

    public void hide(View view) {
        mAvi.smoothToHide();
    }
}
