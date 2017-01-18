package com.kb.workbook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kb.workbook.R;
import com.kb.workbook.utils.LogUtils;
import com.kb.workbook.utils.ScreenUtils;

/**
 * 测试Glide的使用  thumbnail()
 */
public class ImageTestActivity extends AppCompatActivity implements View.OnClickListener {
    private static final java.lang.String TAG = ImageTestActivity.class.getSimpleName();

    private Button mBtnThumb01;
    private Button mBtnThumb03;
    private Button mBtnThumb10;
    // 缩略图
    private ImageView mIvThumb;
    // 原图
    private ImageView mIvOriginal;
    private EditText mEtSize;
    private ImageView mIvSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_test);
        initView();
        setupView();


        Glide.with(this)
                .load(R.mipmap.street)
                .override(200, 900)
                .into(mIvOriginal);

        LogUtils.d(TAG, "screen width: "+ ScreenUtils.getScreenWidth(this) + ",height: "+ScreenUtils.getScreenHeight(this));
    }

    private void initView() {
        mBtnThumb01 = (Button) findViewById(R.id.test_thumb_01);
        mBtnThumb03 = (Button) findViewById(R.id.test_thumb_03);
        mBtnThumb10 = (Button) findViewById(R.id.test_thumb_10);
        mEtSize = (EditText) findViewById(R.id.test_et_image_size);
        mIvThumb = (ImageView) findViewById(R.id.test_image1_thumb);
        mIvOriginal = (ImageView) findViewById(R.id.test_image2_original);
        mIvSrc = (ImageView) findViewById(R.id.test_image3_src);
    }

    private void setupView() {
        mBtnThumb01.setOnClickListener(this);
        mBtnThumb03.setOnClickListener(this);
        mBtnThumb10.setOnClickListener(this);

        mIvThumb.setOnClickListener(this);
        mIvOriginal.setOnClickListener(this);
        mIvSrc.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.test_thumb_01:
                Glide.with(this)
                        .load(R.mipmap.street)
                        .thumbnail(0.1f)
                        .into(mIvThumb);
                break;

            case R.id.test_thumb_03:
                Glide.with(this)
                        .load(R.mipmap.street)
                        .thumbnail(0.3f)
                        .into(mIvThumb);
                break;

            case R.id.test_thumb_10:
                Glide.with(this)
                        .load(R.mipmap.street)
                        .thumbnail(1f)
                        .into(mIvThumb);
                break;

            case R.id.test_image1_thumb:
                ViewGroup.LayoutParams layoutParams1 = mIvThumb.getLayoutParams();

                LogUtils.d(TAG, "thumb宽：" + layoutParams1.width + "高：" + layoutParams1.height);
                break;
            case R.id.test_image2_original:
                ViewGroup.LayoutParams layoutParams2 = mIvOriginal.getLayoutParams();

                LogUtils.d(TAG, "original宽：" + layoutParams2.width + "高：" + layoutParams2.height);
                break;
            case R.id.test_image3_src:
                ViewGroup.LayoutParams layoutParams3 = mIvSrc.getLayoutParams();

                LogUtils.d(TAG, "src宽：" + layoutParams3.width + "高：" + layoutParams3.height);
                break;
        }
    }

}
