package com.kb.workbook.activity.idea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kb.workbook.R;
import com.kb.workbook.adapter.IdeaPtrListViewAdapter;
import com.kb.workbook.utils.LogUtils;
import com.kb.workbook.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class RefreshActivity extends AppCompatActivity {

    private static final java.lang.String TAG = RefreshActivity.class.getSimpleName();

    private PullToRefreshListView mPtrListview;

    private List<String> mList = new ArrayList<>();

    private int page = 1;
    private IdeaPtrListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        // view
        mPtrListview = (PullToRefreshListView) findViewById(R.id.ptr_listview);

        // ctrl
        mAdapter = new IdeaPtrListViewAdapter(this, mList);
        mAdapter.setRefreshListView(mPtrListview);

        mPtrListview.setAdapter(mAdapter);
        mPtrListview.setMode(PullToRefreshBase.Mode.BOTH);
        mPtrListview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                initData();
            }
        });
        mPtrListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ToastUtils.showShort("click " + i);
                mAdapter.updateItem(i);
            }
        });

        // model
        initData();
    }

    private void initData() {

        if (page == 1) {
            mList.clear();
        }

//        for (int i = (page - 1) * NUM; i < page * NUM; i++) {
        for (int i = 0; i < 20; i++) {
            mList.add("第"+ page + "页 --> " + i);
        }

        closeRefresh();
        mAdapter.notifyDataSetChanged();
    }

    private void closeRefresh() {
        mPtrListview.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (mPtrListview != null && mPtrListview.isRefreshing()){
                    mPtrListview.onRefreshComplete();
                }
            }
        }, 1000);

    }

}
