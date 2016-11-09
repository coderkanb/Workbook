package com.kb.mallpractice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kb.mallpractice.R;
import com.kb.mallpractice.utils.ImageLoader;

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