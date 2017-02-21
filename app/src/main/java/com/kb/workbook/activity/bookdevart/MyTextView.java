package com.kb.workbook.activity.bookdevart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.kb.workbook.utils.ToastUtils;

/**
 * Created by Administrator on 2017/2/21.
 */

public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean ret = true;
        if (ret){
            ToastUtils.showShort("view 处理事件");

        }else {
            ToastUtils.showShort("view 未处理事件");

        }
        return ret;
//        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        return super.dispatchTouchEvent(event);
    }

    /**
     * View 没有onInterceptTouchEvent()方法
     */
}
