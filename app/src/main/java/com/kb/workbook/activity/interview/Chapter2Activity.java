package com.kb.workbook.activity.interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kb.workbook.R;
import com.kb.workbook.utils.LogUtils;

public class Chapter2Activity extends AppCompatActivity {

    private static final java.lang.String TAG = Chapter2Activity.class.getSimpleName();

    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);

        mLinearLayout = (LinearLayout) findViewById(R.id.chapter2_ll);

        int measuredWidth = mLinearLayout.getMeasuredWidth();
        int measuredHeight = mLinearLayout.getMeasuredHeight();
        LogUtils.d(TAG, "measuredWidth: " + measuredWidth + ", measuredHeight: " + measuredHeight);

        ViewGroup.LayoutParams layoutParams = mLinearLayout.getLayoutParams();
        LogUtils.d(TAG, "width: " + layoutParams.width + ", height: " + layoutParams.height);
    }
}
