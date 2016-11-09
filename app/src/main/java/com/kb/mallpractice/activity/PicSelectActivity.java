package com.kb.mallpractice.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.kb.mallpractice.R;
import com.kb.mallpractice.bean.HomeProductModel;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import me.nereo.multi_image_selector.MultiImageSelector;

/**
 * 试用图片选择器
 * https://github.com/lovetuzitong/MultiImageSelector
 *
 * 项目中用到了三方okhttputils，好像因此报错，引入Picasso包后好了
 */
public class PicSelectActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE = 1010;
    private XRecyclerView mRecyclerView;
    private List<String> datas;
    private ArrayList<String> mSelectPath;
    private CommonAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_select);

        datas = new ArrayList<>();
        mSelectPath = new ArrayList<>();
        mRecyclerView = (XRecyclerView) findViewById(R.id.pic_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setPullRefreshEnabled(false);
        mAdapter = new CommonAdapter<String>(this, R.layout.item_pic_select, datas) {

            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                ImageView imageView = holder.getView(R.id.pic_item_imageview);
                Glide.with(PicSelectActivity.this).load(s).into(imageView);
            }
        };
        mRecyclerView.setAdapter(mAdapter);
    }

    public void selectPic(View view) {
        /**
         * 报错
         *  java.lang.RuntimeException: Picasso detected an unsupported OkHttp on the classpath.
         To use OkHttp with this version of Picasso, you'll need:
         1. com.squareup.okhttp:okhttp:1.6.0 (or newer)
         2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)
         加上Picasso包后好用了
         */
        MultiImageSelector.create(this)
                .showCamera(true) // show camera or not. true by default
                .count(3) // max select image size, 9 by default. used width #.multi()
//        .single() // single mode
                .multi() // multi mode, default mode;
                .origin(mSelectPath) // original select data set, used width #.multi()
                .start(PicSelectActivity.this, REQUEST_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                mSelectPath = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                StringBuilder sb = new StringBuilder();
                for (String p : mSelectPath) {
                    sb.append(p);
                    sb.append("\n");
                }
                datas.clear();
                datas.addAll(mSelectPath);
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}
