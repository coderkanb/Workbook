package com.kb.workbook.activity.note;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kb.workbook.R;
import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private List<View> mViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewList = new ArrayList<>();
        TextView textView1 = new TextView(this);
        textView1.setText("textView1");
        mViewList.add(textView1);
        TextView textView2 = new TextView(this);
        textView2.setText("textView2");
        mViewList.add(textView2);
        TextView textView3 = new TextView(this);
        textView3.setText("textView3");
        mViewList.add(textView3);
        TextView textView4 = new TextView(this);
        textView4.setText("textView4");
        mViewList.add(textView4);

        final String[] titles = new String[]{"this", "is", "a", "test"};

        ViewPager viewPager = (ViewPager) findViewById(R.id.note_view_pager);

        PagerAdapter pagerAdapter1 = new PagerAdapter() {
            @Override
            public int getCount() {
                return mViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);
                container.removeView(mViewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mViewList.get(position));
                return mViewList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position % titles.length];
            }


        };


        PagerAdapter pagerAdapter2 = new PagerAdapter() {
            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                return super.instantiateItem(container, position);

            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);

            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position % titles.length];

            }
        };

        viewPager.setAdapter(pagerAdapter1);

        TitlePageIndicator titlePageIndicator = (TitlePageIndicator) findViewById(R.id.indicator_title_page);
        titlePageIndicator.setViewPager(viewPager);
        titlePageIndicator.setTextColor(Color.BLACK);

        LinePageIndicator linePageIndicator = (LinePageIndicator) findViewById(R.id.indicator_line_page);
        linePageIndicator.setViewPager(viewPager);

        /**
         * https://github.com/JakeWharton/ViewPagerIndicator
         * demo演示的是ViewPagerIndicator的使用
         * 1. 标题是pagerAdapter中getPageTitle()返回的，重写即可
         * 2. viewpager/ pagerAdapter/ indicator
         * viewpager.setAdapter(pagerAdapter) -- 像ListView一样使用
         * indicator.setViewPager(viewPager)
         */
    }
}
