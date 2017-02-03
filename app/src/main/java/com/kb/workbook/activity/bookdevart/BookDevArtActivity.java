package com.kb.workbook.activity.bookdevart;

import android.os.Bundle;
import android.view.View;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;

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

    public void onLaunchMode(View view) {
        startActivity(LaunchModeActivity.class);
    }

    public void toEvent(View view) {
        startActivity(EventActivity.class);
    }
}
