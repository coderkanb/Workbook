package com.kb.mallpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kb.mallpractice.widget.LoadingDialog;

public class TestActivity extends BaseActivity {

    private Button mBtnLoad;
    private Button mBtnStop;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initView();
        setupView();

        mLoadingDialog = new LoadingDialog(this);
    }

    private void initView() {
        mBtnLoad = (Button) findViewById(R.id.test_btn_load);
        mBtnStop = (Button) findViewById(R.id.test_btn_stop);
    }

    private void setupView() {
        mBtnLoad.setOnClickListener(this);
        // 停止按钮是点不了的，如果dialog不消失
//        mBtnStop.setOnClickListener(this);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.test_btn_load:
                mLoadingDialog.show();
                break;
//            case R.id.test_btn_stop:
//                mLoadingDialog.dismiss();
//                break;
        }
    }
}
