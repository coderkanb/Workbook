package com.kb.workbook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.kb.workbook.R;

public class TaskActivity extends AppCompatActivity {

    private ImageView mIvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        mIvShow = (ImageView) findViewById(R.id.task_iv_show);
    }

    public void onSync(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_task_sync);
        mIvShow.startAnimation(animation);

    }
}
