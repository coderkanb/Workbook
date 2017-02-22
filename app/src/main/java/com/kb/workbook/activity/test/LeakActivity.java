package com.kb.workbook.activity.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.workbook.R;

/**
 * 内存泄漏 例2
 *
 * Created by Administrator at 2017/2/22.
 */
public class LeakActivity extends AppCompatActivity {
    private static Context sContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);

        sContext = this;
    }

    public void close(View view) {
//        sContext = null;
        finish();
    }
}
