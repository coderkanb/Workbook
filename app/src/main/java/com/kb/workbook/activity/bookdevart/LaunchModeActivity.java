package com.kb.workbook.activity.bookdevart;

import android.os.Bundle;
import android.view.View;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;

/**
 * 1.2 启动模式
 * <p/>
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

//        Intent intent = new Intent(this, BActivity.class);
//        if (getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null){
//            startActivity(intent);
//        }



    }
}
