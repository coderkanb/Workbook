package com.kb.workbook.activity.bookdevart;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

import com.kb.workbook.R;
import com.kb.workbook.utils.LogUtils;

/**
 * View的事件体系
 *
 * Created by sesame on 2017/1/23.
 */
public class EventActivity extends AppCompatActivity {

    private static final java.lang.String TAG = EventActivity.class.getSimpleName();
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollview);
//        scrollView.smoothScrollTo(0, 0);

        Scroller scroller = new Scroller(this);

        mTextView = (TextView) findViewById(R.id.event_tv);
        scrollView.addView(new TextView(this));
    }


    public void calc(View view) {
        LogUtils.d(TAG, "left=" + mTextView.getLeft() + ", right=" + mTextView.getRight() + ", top=" + mTextView.getTop() + ", bottom=" + mTextView.getBottom());
        LogUtils.d(TAG, "x=" + mTextView.getX() + ", y=" + mTextView.getY() + ", translationX=" + mTextView.getTranslationX() + ", translationY=" + mTextView.getTranslationY());

    }
}
