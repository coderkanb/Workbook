package com.kb.mallpractice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.kb.mallpractice.R;
import com.kb.mallpractice.adapter.HomeRecyclerAdapter;
import com.kb.mallpractice.bean.HomeProductModel;
import com.kb.mallpractice.client.ClientAPI;
import com.kb.mallpractice.utils.ToastUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 用RecyclerView别人写的首页
 */
public class HomeActivity extends AppCompatActivity {

    // 今日新品物品数据集
    private List<HomeProductModel.DataBean> mProductInfoList;

    //每日上新的分页控制
    private int mEveryDayPage = 1;
    //控制是否可分页
    private boolean isHaveNextNews = false;
    private XRecyclerView mRecyclerView;
    private HomeRecyclerAdapter mRecyclerAdapter;

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
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager( 2,
                StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

//                if (NetStateUtils.isNetworkAvailable(getContext())){
                    //刷新抢购
//                   initPanicBuying();
//                    refreshPanicBuying();
                    //刷新每日上新
                    mEveryDayPage=1;
                    isHaveNextNews=true;
//                    mHomeGoodGridAdapter.clear();
//                   mHomeGoodGridAdapter.notifyDataSetChanged();
                    initData();
//                    initTime();

//                }else {
//                    mLLUNNetWork.setVisibility(View.VISIBLE);
//                }
            }

            @Override
            public void onLoadMore() {
                if (isHaveNextNews){
                    ++mEveryDayPage;
                    initData();
                }else{
                    ToastUtils.showShort("最后一页");
                }
            }
        });

        mRecyclerAdapter = new HomeRecyclerAdapter(this, mProductInfoList);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    private void initData() {
        String url= ClientAPI.API_POINT+ClientAPI.EVERYDAY_NEW+mEveryDayPage;
//        LogUtils.e("EVERYDAY_NEW",url);
        ClientAPI.getGoodsData(url, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
//                if (!NetStateUtils.isNetworkAvailable(getContext())){
//                    mLLUNNetWork.setVisibility(View.VISIBLE);
//                }else {
//                    mLLUNNetWork.setVisibility(View.GONE);
//                }
//                UNNetWorkUtils.unNetWorkOnlyNotify(getContext(),e);
            }

            @Override
            public void onResponse(String response, int id) {
                //有网隐藏提示
//                mLLUNNetWork.setVisibility(View.GONE);
                //获得数据
                if (!TextUtils.isEmpty(response.toString().trim())){
                    HomeProductModel homeProductModel = new Gson().fromJson(response.toString(), HomeProductModel.class);
                    isHaveNextNews=(homeProductModel.getNext_page_url()!=null);
                    List<HomeProductModel.DataBean> listAdd=homeProductModel.getData();
//                   reSetEveryDayNew(listAdd)
                    if (mEveryDayPage == 1){
                        mProductInfoList.clear();
                    }
                    mProductInfoList.addAll(listAdd);
                }
                mRecyclerAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete();
                mRecyclerView.loadMoreComplete();
            }
        });

    }
}
