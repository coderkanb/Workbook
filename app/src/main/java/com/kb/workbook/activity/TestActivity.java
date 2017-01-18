package com.kb.workbook.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;
import com.kb.workbook.utils.ToastUtils;
import com.kb.workbook.widget.LoadingDialog;

public class TestActivity extends BaseActivity {

    private Button mBtnLoad;
    private Button mBtnStop;
    private LoadingDialog mLoadingDialog;
    private Button mBtnSubString;

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
        mBtnSubString = (Button) findViewById(R.id.test_substring);

    }

    private void setupView() {
        mBtnLoad.setOnClickListener(this);
        // 停止按钮是点不了的，如果dialog不消失
//        mBtnStop.setOnClickListener(this);
        mBtnSubString.setOnClickListener(this);

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
            case R.id.test_substring:
                String message = "request failed , reponse's code is : 500";
                String left = message.substring(0, message.indexOf(":")).trim();
                Log.d(TAG, "widgetClick: left: " + left);
                if (isNum(left)){
                    // 409 : 密码错误
                    if (!TextUtils.isEmpty(message)) {
                        String right = message.substring(message.indexOf(":") + 1).trim();
                        Toast.makeText(this, right, Toast.LENGTH_SHORT).show();
                    }

                }else {
                    // request failed , reponse's code is : 500
                    ToastUtils.showShort(message);
                }

                break;

        }
    }

    // 判断是否是数字
    public static boolean isNum(String str){
        return str.matches("[0-9]*");
    }
}
