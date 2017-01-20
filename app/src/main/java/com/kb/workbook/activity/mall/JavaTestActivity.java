package com.kb.workbook.activity.mall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        TextView textView = (TextView) findViewById(R.id.java_test_tv1);
        String name = null;
        textView.setText(name);
    }
}
