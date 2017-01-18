package com.kb.workbook.activity.mall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kb.workbook.R;
import com.kb.workbook.utils.LogUtils;

public class JavaTestActivity extends AppCompatActivity {
    public static final String TAG = JavaTestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_test);

        String str = "";
        LogUtils.d(TAG, "str: " + str.length());
    }
}
