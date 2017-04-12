package com.kb.workbook.activity.test;

import android.graphics.Color;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kb.workbook.R;

public class Toast2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast2);
    }

    public void toastMe(View view) {
//        SuperActivityToast.create(this, new Style(), Style.TYPE_BUTTON)
//                .setButtonText("UNDO")
//                .setButtonIconResource(R.mipmap.ic_undo)
//                .setOnButtonClickListener("good_tag_name", null, onButtonClickListener)
//                .setProgressBarColor(Color.WHITE)
//                .setText("Email deleted")
//                .setDuration(Style.DURATION_LONG)
//                .setFrame(Style.FRAME_LOLLIPOP)
//                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_PURPLE))
//                .setAnimations(Style.ANIMATIONS_POP).show();
    }

//    private final SuperActivityToast.OnButtonClickListener onButtonClickListener =
//            new SuperActivityToast.OnButtonClickListener() {
//
//                @Override
//                public void onClick(View view, Parcelable token) {
//                    SuperToast.create(view.getContext(), "OnClick!", Style.DURATION_SHORT)
//                            .setPriorityLevel(Style.PRIORITY_HIGH).show();
//                }
//            };
}
