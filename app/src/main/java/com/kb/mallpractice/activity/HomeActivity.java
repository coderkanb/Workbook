package com.kb.mallpractice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.kb.mallpractice.R;
import com.kb.mallpractice.adapter.HomeQuickAdapter;
import com.kb.mallpractice.adapter.HomeQuickAdapter2;
import com.kb.mallpractice.bean.HomeProductModel;
import com.kb.mallpractice.client.ClientAPI;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 用RecyclerView改写别人写的首页，用到的变量名没改
 */
public class HomeActivity extends AppCompatActivity {

    // 今日新品物品数据集
    private List<HomeProductModel.DataBean> mProductInfoList;
    //每日上新的分页控制
    private int mPageNo = 1;
    //控制是否可分页
    private boolean hasNext = false;

    private XRecyclerView mRecyclerView;
    //    private RecyclerView mRecyclerView;

//    private HomeRecyclerAdapter mRecyclerAdapter;
//    private HomeQuickAdapter mRecyclerAdapter;
    private HomeQuickAdapter2 mRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mProductInfoList = new ArrayList<>();
        initRecyclerView();
        initData();
    }

    private void initRecyclerView() {
        mRecyclerView = (XRecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

//        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
//            @Override
//            public void onRefresh() {
//
//                    //刷新每日上新
//                    mPageNo=1;
//                    hasNext=true;
//                    initData();
//            }
//
//            @Override
//            public void onLoadMore() {
//                if (hasNext){
//                    ++mPageNo;
//                    initData();
//                }else{
//                    mRecyclerView.setIsnomore(true);
//                }
//            }
//        });

//        mRecyclerAdapter = new HomeRecyclerAdapter(this, mProductInfoList);
        mRecyclerAdapter = new HomeQuickAdapter2(6);
//        mRecyclerAdapter.openLoadAnimation();
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    private void initData() {
        String url = ClientAPI.API_POINT + ClientAPI.EVERYDAY_NEW + mPageNo;

        ClientAPI.getGoodsData(url, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                //获得数据
                if (!TextUtils.isEmpty(response.toString().trim())) {
                    HomeProductModel homeProductModel = new Gson().fromJson(response.toString(), HomeProductModel.class);
                    hasNext = (homeProductModel.getNext_page_url() != null);
                    List<HomeProductModel.DataBean> listAdd = homeProductModel.getData();
                    if (mPageNo == 1) {
                        mProductInfoList.clear();
                    }
                    mProductInfoList.addAll(listAdd);
                }
                mRecyclerAdapter.notifyDataSetChanged();
//                mRecyclerView.refreshComplete();
//                mRecyclerView.loadMoreComplete();
            }
        });

    }
}
