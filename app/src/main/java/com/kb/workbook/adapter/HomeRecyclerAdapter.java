package com.kb.workbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kb.workbook.R;
import com.kb.workbook.bean.HomeProductModel;
import com.kb.workbook.utils.ImageUtils;
import com.kb.workbook.utils.ScreenUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>  {

    private Context mContext;
    private List<HomeProductModel.DataBean> mList;

    public HomeRecyclerAdapter(Context context, List<HomeProductModel.DataBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public HomeRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_good_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeRecyclerAdapter.ViewHolder holder, int position) {

        // 3. 展示数据
        HomeProductModel.DataBean productInfo = mList.get(position);

        if (productInfo!=null) {
            if (productInfo.getImage() != null && productInfo.getImage().getImage_path() != null && productInfo.getImage().getImage_base_name() != null) {
                String imgUrl = productInfo.getImage().getImage_path() + productInfo.getImage().getImage_base_name();
                if (!TextUtils.isEmpty(imgUrl)) {
                    imgUrl = productInfo.getImage().getImage_path() + "/" + productInfo.getImage().getImage_base_name();

                    Glide.with(mContext)
                            .load(ImageUtils.getThumb(imgUrl, ScreenUtils.getScreenWidth(mContext) / 2, 0))
                            .error(R.mipmap.list_image_loading)
                            .placeholder(R.mipmap.list_image_loading)
                            .into(holder.mImageView);
                }
            }
            if (productInfo.getName() != null) {
                holder.mTvTitle.setText(productInfo.getName());
            }
            if (productInfo.getSize() != null) {
                String price = "￥" + productInfo.getSize().getPrice();
                holder.mTvPrice.setText(price);
                String integral = "+" + productInfo.getSize().getIntegration_price() + "积分";
                holder.mTvPoints.setText(integral);
            }
        }
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (mList != null) {
            ret = mList.size();
        }
        return ret;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTvTitle;
        private TextView mTvPrice;
        private TextView mTvPoints;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.home_good_grid_item_iv_pic);
            mTvTitle = (TextView) itemView.findViewById(R.id.home_good_grid_item_tv_title);
            mTvPrice = (TextView) itemView.findViewById(R.id.home_good_grid_item_tv_price);
            mTvPoints = (TextView) itemView.findViewById(R.id.home_good_grid_item_tv_points);
        }
    }
}
