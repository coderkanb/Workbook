package com.kb.workbook.activity.bookdevart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.kb.workbook.utils.ToastUtils;

/**
 * Created by Administrator on 2017/2/21.
 */

public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean ret = true;
//        if (ret){
//            ToastUtils.showShort("view group 拦截事件");
//
//        }else {
//            ToastUtils.showShort("view group 未拦截事件");
//
//        }
//        return ret;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean ret = true;
        if (ret){
            ToastUtils.showShort("view group 处理事件");

        }else {
            ToastUtils.showShort("view group 未处理事件");

        }
        return ret;
//        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }
}
