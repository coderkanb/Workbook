package com.kb.mallpractice.activity.mall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.kb.mallpractice.BaseActivity;
import com.kb.mallpractice.R;

public class MallActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_mall;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void onTextView(View view) {
        startActivity(TextViewActivity.class);
    }
}
