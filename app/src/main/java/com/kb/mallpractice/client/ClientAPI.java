package com.kb.mallpractice.client;

import android.text.TextUtils;
import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;

/**
 * 网络请求
 *
 */
public class ClientAPI {

    public static final String TAG = ClientAPI.class.getSimpleName();

    // 外网
    public static final String API_POINT = "http://api.bjaiyouyou.com/";

    //搜索拼接地址
    public static final String SEARCH = "api/v1/product/searchAll?keyword=";
    //每日上新拼接地址
    public static final String EVERYDAY_NEW = "api/v1/product/allNow?page=";

    private ClientAPI() {
    }


    public static void getGoodsData(final String url, final StringCallback callback) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }
}
