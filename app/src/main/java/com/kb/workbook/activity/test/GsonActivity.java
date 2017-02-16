package com.kb.workbook.activity.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.kb.workbook.R;
import com.kb.workbook.bean.HomeProductModel;
import com.kb.workbook.utils.LogUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class GsonActivity extends AppCompatActivity {

    private static final java.lang.String TAG = GsonActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        String json = "adjflajfdasdlfja";

        Gson gson = new Gson();
        try {
            HomeProductModel homeProductModel = gson.fromJson(json, HomeProductModel.class);
        }catch (Exception e){
            LogUtils.d(TAG, "[" + this.getClass() + "]\n[gson] " + e.getMessage() + "\n[json] " + json);
            e.printStackTrace();

//            MobclickAgent.reportError(mContext,
//                    "[" + mContext.getClass() + "]"
//                            + "\n[" + mType + "]"
//                            + "\n[gson] " + e.getMessage()
//                            + "\n[json] " + str
//            );


//            StringWriter stringWriter = new StringWriter();
//            e.printStackTrace(new PrintWriter(stringWriter, true));
//            MobclickAgent.reportError(mContext,
//                    "[异常信息]\n" + stringWriter.toString()
//                            + "\n[响应数据]\n" + str
//            );
        }
    }
}
