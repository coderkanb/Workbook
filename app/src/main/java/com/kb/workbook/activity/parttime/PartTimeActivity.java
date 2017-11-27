package com.kb.workbook.activity.parttime;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;
import com.kb.workbook.bean.MovieModel;
import com.kb.workbook.utils.JsonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.blurry.Blurry;

/**
 * 创建时间：2017-11-27 9:46
 * 描述：实现一些效果
 * ViewPager可以预览的那种(viewpager画廊效果)
 * 接口数据：https://www.juhe.cn/docs/api/id/42/aid/125
 * 参考：http://blog.csdn.net/codenoodles/article/details/50992113
 * http://www.apkbus.com/forum.php?mod=viewthread&tid=257794&_dsign=517e4163
 */
public class PartTimeActivity extends BaseActivity {

    @BindView(R.id.part_time_view_pager)
    ViewPager mViewPager;
    @BindView(R.id.part_time_background)
    ImageView mIvBackground;
    @BindView(R.id.part_time_container)
    FrameLayout mContainer;

    private List<MovieModel.ResultBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_time);
        ButterKnife.bind(this);

        setupViewPager();
    }

    private void setupViewPager() {

        mViewPager.setAdapter(new MyPagerAdapter(this, getData()));
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.setOffscreenPageLimit(3);
//        mViewPager.setPageMargin(5);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                List<MovieModel.ResultBean> data = getData();
                MovieModel.ResultBean resultBean = data.get(position);
                Glide.with(PartTimeActivity.this).load(resultBean.getPic_url()).into(mIvBackground);
//                Blurry.with(PartTimeActivity.this).capture(mIvBackground).into(mIvBackground);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return 0;
    }

    @Override
    public void widgetClick(View v) {
    }

    public List<MovieModel.ResultBean> getData() {
        String json = JsonUtils.getJson(this, "moviesToday.json");
        MovieModel movieModel = new Gson().fromJson(json, MovieModel.class);
        return movieModel.getResult();
    }
}
