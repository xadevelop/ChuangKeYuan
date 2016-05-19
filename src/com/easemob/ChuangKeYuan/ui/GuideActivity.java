package com.easemob.ChuangKeYuan.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.easemob.ChuangKeYuan.R;
import com.easemob.ChuangKeYuan.utils.Contacts;
import com.easemob.ChuangKeYuan.utils.SharedPreferencesUtil;

import java.util.ArrayList;

/**
 * Created by Say GoBay on 2016/5/16.
 */
public class GuideActivity extends Activity implements OnClickListener {

    private ViewPager mViewpager;
    private Button mGoHome;
    /**
     * 图片资源的id数组
     */
    private int[] mImageIds = new int[] { R.drawable.guide_1,
            R.drawable.guide_2, R.drawable.guide_3 };
    private ArrayList<ImageView> mImageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guid);

        initView();
        setMessasge();
    }


    /**
     * 初始化控件
     */
    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.vp_guid_viewpager);
        mGoHome = (Button) findViewById(R.id.btn_guid_goHome);
        mImageViews = new ArrayList<ImageView>();
    }

    /**
     * 设置显示信息
     */
    private void setMessasge() {

        // 根据图片个数，创建imageview的个数
        for (int i = 0; i < mImageIds.length; i++) {
            // 创建Imageview
            ImageView imageView = new ImageView(this);
            // 将图片设置给imageview
            imageView.setBackgroundResource(mImageIds[i]);
            // 将创建的imageview存放到集合或者数组中
            mImageViews.add(imageView);
        }

        mViewpager.setAdapter(new Myadapter());
        // 当切换到第三个界面，显示button按钮，第一和第二个界面不显示
        // 监听viewpager界面切换操作
        mViewpager.setOnPageChangeListener(onPageChangeListener);
    }
    // viewpager界面切换监听
    OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {
        // 当界面切换完成调用的方法
        // position : 切换界面的位置
        @Override
        public void onPageSelected(int position) {
            // 当切换到第三个界面，显示button按钮，第一和第二个界面不显示
            if (position == mImageViews.size() - 1) {
                // 显示button按钮
                mGoHome.setVisibility(View.VISIBLE);
                mGoHome.setOnClickListener(GuideActivity.this);
            } else {
                // 隐藏button按钮
                mGoHome.setVisibility(View.INVISIBLE);
                // 取消button的点击事件
                mGoHome.setOnClickListener(null);
            }
        }

        // 滑动的时候调用的方法
        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {

        }

        // 滑动状态改变的时候
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private class Myadapter extends PagerAdapter {
        // 设置条目的个数，imageview的个数
        @Override
        public int getCount() {
            return mImageViews.size();
        }

        // 判断viewpager的页面的view是否和object一致
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        // 添加viewpager的条目
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 根据条目的位置获取条目显示的相应的图片
            ImageView imageView = mImageViews.get(position);
            // 将imageview添加到viewpager中
            container.addView(imageView);
            // 返回的就是添加的view对象
            return imageView;
        }

        // 销毁viewpager的条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            container.removeView((View) object);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_guid_goHome:
                // 跳转主界面
                startActivity(new Intent(GuideActivity.this, HomeActivity.class));
                // 保存不是第一次进入的状态（获取是在splashactivity）
                SharedPreferencesUtil.saveBoolean(getApplicationContext(),
                        Contacts.FIRST_ENTER, false);
                // 销毁界面
                finish();
                break;

            default:
                break;
        }
    }
    }
