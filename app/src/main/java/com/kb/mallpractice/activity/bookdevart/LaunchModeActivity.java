package com.kb.mallpractice.activity.bookdevart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.mallpractice.BaseActivity;
import com.kb.mallpractice.R;

/**
 * 1.2 启动模式
 *
 * Created by sesame on 2017/1/3.
 */
public class LaunchModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_launch_mode;
    }

    @Override
    public void widgetClick(View v) {

    }

    public void openA(View view) {
        startActivity(AActivity.class);
    }
}
