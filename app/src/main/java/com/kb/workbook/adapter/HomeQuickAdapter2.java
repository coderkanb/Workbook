package com.kb.workbook.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kb.workbook.R;
import com.kb.workbook.bean.Status;
import com.kb.workbook.data.DataServer;

/**
 * Created by Administrator on 2016/12/7.
 */
public class HomeQuickAdapter2 extends BaseQuickAdapter<Status, BaseViewHolder> {

    public HomeQuickAdapter2() {
        super( R.layout.item_home_good_grid2, DataServer.getSampleData(100));
    }

    public HomeQuickAdapter2(int dataSize) {
        super( R.layout.item_home_good_grid2, DataServer.getSampleData(dataSize));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
//        helper.getConvertView().setBackgroundResource(R.drawable.card_click);
        helper.setText(R.id.tweetName, item.getUserName())
                .setText(R.id.tweetText, item.getText())
                .setText(R.id.tweetDate, item.getCreatedAt())
                .setVisible(R.id.tweetRT, item.isRetweet())
                .addOnClickListener(R.id.tweetAvatar)
                .addOnClickListener(R.id.tweetName)
                .addOnLongClickListener(R.id.tweetText)
        ;
        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.tweetAvatar));
    }


}
