package com.kb.workbook.activity.bookdevart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.kb.workbook.R;
import com.kb.workbook.utils.ToastUtils;

public class Event2Activity extends AppCompatActivity {

    private MyRelativeLayout mRl;
    private MyTextView mTv;
    private TextView mTvShow;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event2);

        mRl = (MyRelativeLayout) findViewById(R.id.event2_rl);
        mTv = (MyTextView) findViewById(R.id.event2_tv);
        mTvShow = (TextView) findViewById(R.id.event2_tv_show);

        mRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ToastUtils.showShort("view group");
                mTvShow.setText("[" + count++ + "]\nview group");
            }
        });

        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ToastUtils.showShort("view");
                mTvShow.setText("[" + count++ + "]\nview");
            }
        });

        mRl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }

        });

    }


}
