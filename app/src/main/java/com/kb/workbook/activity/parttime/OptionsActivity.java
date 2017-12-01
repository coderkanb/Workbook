package com.kb.workbook.activity.parttime;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.kb.workbook.BaseActivity;
import com.kb.workbook.R;
import com.kb.workbook.utils.ToastUtils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建时间：2017-11-28 16:56
 * 描述：筛选菜单
 */
public class OptionsActivity extends BaseActivity {

    @BindView(R.id.tab_menu_view)
    LinearLayout mTabMenuView;
    @BindView(R.id.mask_view)
    View mMaskView;
    @BindView(R.id.popup_menu_views)
    FrameLayout mPopupMenuViews;
    @BindView(R.id.content_view)
    FrameLayout mContentView;
    @BindView(R.id.container_view)
    FrameLayout mContainerView;
    //分割线颜色
    private int dividerColor = 0xffcccccc;
    //tab选中颜色
    private int textSelectedColor = 0xff890c85;
    //tab未选中颜色
    private int textUnselectedColor = 0xff111111;
    //遮罩颜色
    private int maskColor = 0x88888888;
    //tab字体大小
    private int menuTextSize = 14;
    private List<String> mOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        ButterKnife.bind(this);

        initPopupMenuViews();
    }

    private void initPopupMenuViews() {
//        TextView textView = new TextView(this);
//        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        textView.setGravity(Gravity.CENTER);
//        textView.setText("选择项1");
//        textView.setBackgroundColor(Color.BLUE);
//
//        mPopupMenuViews.addView(textView);
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

    @OnClick({R.id.tab_menu_view, R.id.mask_view, R.id.popup_menu_views})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_menu_view:
                setMenus();
                showMenu();
                break;
            case R.id.mask_view:
                closeMenu();
                break;
            case R.id.popup_menu_views:
                ToastUtils.showShort("popup_menu_views");
                break;
        }
    }

    private void setMenus() {
        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        listView.setAdapter(new CommonAdapter<String>(this, R.layout.item_options, getOptions()) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.options_item_tv_title, item);
            }
        });
        mPopupMenuViews.removeAllViews();
        mPopupMenuViews.addView(listView);
    }

    private void showMenu() {
        // 显示maskView
        mMaskView.setVisibility(View.VISIBLE);
        mMaskView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_mask_in));

        // 显示popupMenus
        mPopupMenuViews.setVisibility(View.VISIBLE);
        mPopupMenuViews.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_menu_in));
    }

    private void closeMenu() {
        mMaskView.setVisibility(View.GONE);
        mMaskView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_mask_out));

        mPopupMenuViews.setVisibility(View.GONE);
        mPopupMenuViews.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_menu_out));
    }

    public List<String> getOptions() {
        mOptions = new ArrayList<>();
        for (int i =0; i<5;i++){
            mOptions.add("option:" + i);
        }
        return mOptions;
    }
}
