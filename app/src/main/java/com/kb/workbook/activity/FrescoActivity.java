package com.kb.workbook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kb.workbook.R;
import com.kb.workbook.utils.ImageLoader;

public class FrescoActivity extends AppCompatActivity {

    private SimpleDraweeView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);

        mImageView = (SimpleDraweeView) findViewById(R.id.fresco_iv);
        ImageLoader.loadNetImage("https://www.baidu.com/img/bd_logo1.png", mImageView);
    }
}