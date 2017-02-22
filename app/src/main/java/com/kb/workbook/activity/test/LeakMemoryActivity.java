package com.kb.workbook.activity.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.workbook.R;

public class LeakMemoryActivity extends AppCompatActivity {
    private static A a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_memory);

        a = new A();
    }

    public void toClose(View view) {
//        a = null;
        finish();
    }

    class A{

    }
}

