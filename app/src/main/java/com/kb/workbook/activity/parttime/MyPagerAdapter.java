package com.kb.workbook.activity.parttime;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kb.workbook.R;
import com.kb.workbook.bean.MovieModel;

import java.util.List;

import butterknife.BindView;

/**
 * Created by 123 on 2017-11-27.
 */

public class MyPagerAdapter extends PagerAdapter {
    Context mContext;
    List<MovieModel.ResultBean> data;

    public MyPagerAdapter(Context context, List<MovieModel.ResultBean> data) {
        mContext = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_part_time_view_pager, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.view_page_item_iv);
        TextView textView = (TextView) view.findViewById(R.id.view_pager_item_tv);

        MovieModel.ResultBean movieItem = data.get(position);
        Glide.with(mContext).load(movieItem.getPic_url()).into(imageView);
        textView.setText(movieItem.getMovieName());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
