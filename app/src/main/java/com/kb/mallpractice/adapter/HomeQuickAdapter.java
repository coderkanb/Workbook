package com.kb.mallpractice.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kb.mallpractice.R;
import com.kb.mallpractice.bean.HomeProductModel;
import com.kb.mallpractice.utils.ImageUtils;
import com.kb.mallpractice.utils.ScreenUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class HomeQuickAdapter extends BaseQuickAdapter<HomeProductModel.DataBean, BaseViewHolder> {

    public HomeQuickAdapter(int layoutResId, List<HomeProductModel.DataBean> data) {
        super(layoutResId, data);
    }

    public HomeQuickAdapter(List<HomeProductModel.DataBean> data) {
        super(R.layout.item_home_good_grid, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeProductModel.DataBean item) {

        if (item!=null) {

            if (item.getImage() != null && item.getImage().getImage_path() != null && item.getImage().getImage_base_name() != null) {
                String imgUrl = item.getImage().getImage_path() + item.getImage().getImage_base_name();

                if (!TextUtils.isEmpty(imgUrl)) {
                    imgUrl = item.getImage().getImage_path() + "/" + item.getImage().getImage_base_name();

                    Glide.with(mContext)
                            .load(ImageUtils.getThumb(imgUrl, ScreenUtils.getScreenWidth(mContext) / 2, 0))
                            .error(R.mipmap.list_image_loading)
                            .placeholder(R.mipmap.list_image_loading)
                            .into((ImageView) helper.getView(R.id.home_good_grid_item_iv_pic));
                }
            }

            if (item.getName() != null) {
                helper.setText(R.id.home_good_grid_item_tv_title, item.getName());
            }

            if (item.getSize() != null) {
                String price = "￥" + item.getSize().getPrice();
                helper.setText(R.id.home_good_grid_item_tv_price, price);
                String integral = "+" + item.getSize().getIntegration_price() + "积分";
                helper.setText(R.id.home_good_grid_item_tv_points, integral);
            }
        }
    }
}
