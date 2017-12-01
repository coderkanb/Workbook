package com.kb.workbook.activity.parttime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PartTimeContentActivity extends BaseActivity {

    @BindView(R.id.tv_view_pager)
    TextView mTvViewPager;
    @BindView(R.id.tv_options)
    TextView mTvOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_time_content);
        ButterKnife.bind(this);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return 0;
    }

    @Override
    public void widgetClick(View v) {

    }

    @OnClick({R.id.tv_view_pager, R.id.tv_options})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_view_pager:
                startActivity(PartTimeActivity.class);
                break;
            case R.id.tv_options:
                startActivity(OptionsActivity.class);
                break;
        }
    }
}
