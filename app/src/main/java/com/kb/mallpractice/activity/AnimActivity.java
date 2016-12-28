package com.kb.mallpractice.activity;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kb.mallpractice.R;

public class AnimActivity extends AppCompatActivity {

    private TextView mTvTip;
    private LinearLayout mRootView;
    private boolean isShow = true;
    private ImageView view1;
    private ImageView view2;
    private AlphaAnimation animationOut;
    private AlphaAnimation animationIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        mRootView = (LinearLayout) findViewById(R.id.root);
        mTvTip = (TextView) findViewById(R.id.anim_tv_tip);

        view1 = (ImageView) findViewById(R.id.view_1);
        view2 = (ImageView) findViewById(R.id.view_2);
        initAnimation();
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofInt(view2,"top",view2.getTop()-view1.getHeight()).setDuration(500).start();
                ObjectAnimator.ofInt(view2,"bottom",view2.getBottom()-view1.getHeight()).setDuration(500).start();
                view1.startAnimation(animationOut);
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view1.getVisibility() == View.GONE){
                    ObjectAnimator.ofInt(view2,"top",view2.getTop()+view1.getHeight()).setDuration(500).start();
                    ObjectAnimator.ofInt(view2,"bottom",view2.getBottom()+view1.getHeight()).setDuration(500).start();
                    view1.startAnimation(animationIn);

                }
            }
        });
    }
    private void setClickable(boolean which){
        view1.setClickable(which);
        view2.setClickable(which);
    }
    private void initAnimation(){
        animationOut = new AlphaAnimation(1f,0f);
        animationOut.setDuration(500);
        animationOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                setClickable(false);
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                view1.setVisibility(View.GONE);
                setClickable(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //
        animationIn = new AlphaAnimation(0f,1f);
        animationIn.setDuration(500);
        animationIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                setClickable(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view1.setVisibility(View.VISIBLE);
                setClickable(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void onHideShow(View view) {
        int height = mTvTip.getHeight();
        ViewWrapper wrapper = new ViewWrapper(mTvTip);
        if (isShow) {
            ValueAnimator anim = ObjectAnimator.ofInt(wrapper, "height", height, 0);
//        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mTvTip, "scaleY", 1f, 0);

            anim.setDuration(2000);
//        anim2.setDuration(2000);
//        anim.start();

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(anim);
            animatorSet.start();

//        LayoutTransition transition = new LayoutTransition();
//        mRootView.setLayoutTransition(transition);
//        mRootView.setVisibility(View.GONE);
        } else {

            ValueAnimator anim = ObjectAnimator.ofInt(wrapper, "height", 0, 100);
            anim.setDuration(1000);
            anim.start();
        }

        isShow = !isShow;
    }

    private static class ViewWrapper {
        private View mTarget;

        public ViewWrapper(View target) {
            mTarget = target;
        }

        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }

        public int getHeight() {
            return mTarget.getLayoutParams().height;
        }

        public void setHeight(int height) {
            mTarget.getLayoutParams().height = height;
            mTarget.requestLayout();
        }


    }
}
