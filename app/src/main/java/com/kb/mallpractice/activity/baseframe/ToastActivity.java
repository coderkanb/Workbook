package com.kb.mallpractice.activity.baseframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kb.mallpractice.R;
import com.kb.mallpractice.utils.ToastUtils;

/**
 * Toast封装
 *
 * Created by sesame on 2017/1/4.
 */
public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void onShowToastNormal(View view) {
        UIUtil.showToastShort("普通-夜来风雨声，花落知多少。");
    }

    public void onShowToastColor(View view) {
        UIUtil.showToastLong("颜色-夜来风雨声，花落知多少。", "#ffff00");
    }

    public void onRaw(View view) {
        Toast.makeText(this, "原生-夜来风雨声，花落知多少。", Toast.LENGTH_SHORT).show();
    }
}
