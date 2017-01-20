package com.kb.workbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kb.workbook.R;

import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */
public class IdeaPtrListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;
    private PullToRefreshListView mListView;

    public IdeaPtrListViewAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    public void setRefreshListView(PullToRefreshListView listView) {
        mListView = listView;
    }

    /**
     * 刷新指定item
     *
     * @param index item在listview中的位置
     */
    public void updateItem(int index) {
        if (mListView == null) {
            return;
        }

        // 获取当前可以看到的item位置
        int visiblePosition = mListView.getRefreshableView().getFirstVisiblePosition();
        //只有当要更新的view在可见的位置时才更新，不可见时，跳过不更新
        if (index - visiblePosition >= 0) {
            // 如添加headerview后 firstview就是hearderview
            // 所有索引+1 取第一个view
            // View view = listview.getChildAt(index - visiblePosition + 1);
            // 获取点击的view
            View view = mListView.getRefreshableView().getChildAt(index - visiblePosition);
            TextView textView = (TextView) view.findViewById(R.id.idea_ptr_lv_item_tv);
            // 获取mDataList.set(ids, item);更新的数据
            // 重新设置界面显示数据
            textView.setText("已点击");
        }
        // 最后那个列表数据别忘记更新， 不然数据源不变，一滚动可能又还原了。
        mList.set(index, "点击过");
    }

    @Override
    public int getCount() {
        int ret = 0;
        ret = (mList == null) ? 0 : mList.size();
        return ret;
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = null;

        // 1. convertView的复用
        if (convertView != null) {
            ret = convertView;
        } else {
            ret = LayoutInflater.from(mContext).inflate(R.layout.item_idea_ptr_listview, parent, false);
        }

        // 2. 减少findViewById的次数
        ViewHolder holder = (ViewHolder) ret.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.tv = (TextView) ret.findViewById(R.id.idea_ptr_lv_item_tv);
            ret.setTag(holder);
        }

        // 3. 展示数据
        holder.tv.setText(mList.get(position));

        return ret;
    }

    class ViewHolder {
        private TextView tv;
    }
}
