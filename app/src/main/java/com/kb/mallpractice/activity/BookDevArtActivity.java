package com.kb.mallpractice.activity;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.mallpractice.BaseActivity;
import com.kb.mallpractice.R;
import com.kb.mallpractice.activity.bookdevart.ActivityLifeActivity;

/**
 * 《Android开发艺术探索》
 *
 * Created by sesame on 2017/1/3.
 */
public class BookDevArtActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_dev_art);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_book_dev_art;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void onScreenChange(View view) {
        startActivity(ActivityLifeActivity.class);
    }
}
