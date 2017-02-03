package com.kb.workbook.activity.mall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kb.workbook.R;
import com.nineoldandroids.animation.ObjectAnimator;

public class TipHideActivity extends AppCompatActivity {

    private TextView mTvTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_hide);

        mTvTip = (TextView) findViewById(R.id.tip_hide_tv);
    }

    public void hideTip(View view) {
        animateHide(mTvTip);

    }

    public void showTip(View view) {
        animateShow(mTvTip);
    }

    private ObjectAnimator animateHide (View targetView) {
        int distance = -targetView.getBottom();
        return animationFromTo(targetView, targetView.getTranslationY(), distance);
    }

    private ObjectAnimator animateShow (View targetView) {
        return animationFromTo(targetView, targetView.getTranslationY(), 0);
    }

    private ObjectAnimator animationFromTo (View view, float start, float end) {
        String propertyName = "translationY";
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, propertyName, start, end);
        animator.start();
        return animator;
    }

}
