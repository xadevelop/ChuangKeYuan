package com.easemob.ChuangKeYuan.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;
import com.easemob.ChuangKeYuan.adapter.TabAdapter;
import com.easemob.ChuangKeYuan.ui.DownloadActivity;
import com.easemob.ChuangKeYuan.ui.LoginActivity;
import com.easemob.ChuangKeYuan.ui.RecordActivity;
import com.easemob.ChuangKeYuan.ui.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Say GoBay on 2016/5/17.
 */
public class HomeFragment extends Fragment implements OnCheckedChangeListener, OnClickListener{

    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonRecommend;
    private RadioButton mRadioButtonBuild;
    private RadioButton mRadioButtonTutor;
    private RadioButton mRadioButtonSpace;
    private RadioButton mRadioButtonSchool;
    private RadioButton mRadioButtonShow;
    private RadioButton mRadioButtonResearch;
    private RadioButton mRadioButtonStudy;
    private RadioButton mRadioButtonTool;
    private ViewPager mViewPager;
    private Fragment recommend;
    private Fragment bulid;
    private Fragment research;
    private Fragment school;
    private Fragment show;
    private Fragment space;
    private Fragment study;
    private Fragment tool;
    private Fragment tutor;

    private List<Fragment> mList;

    private ImageView mImageView;
    //当前被选中的RadioButton距离左侧的距离
    private float mCurrentCheckedRadioLeft;
    //上面的水平滚动控件
    private HorizontalScrollView mHorizontalScrollView;
    TranslateAnimation TranslateAnimation;
    AnimationSet AnimationSet;

    public View view;
    public TextView mTitle;
    public TextView mDes;
    public TextView mRecord;
    public TextView mDownload;
    public TextView mSearch;
    public TextView mAdress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        iniController(view);
        iniListener();
        mRadioButtonRecommend.setChecked(true);
        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();
        return view;
    }

    /**
     * RadioGroup点击CheckedChanged监听
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        AnimationSet = new AnimationSet(true);
        Log.i("zj", "checkedid=" + checkedId);
        AnimationSet.setFillBefore(false);
        AnimationSet.setFillAfter(true);
        AnimationSet.setDuration(100);
        //开始上面蓝色横条图片的动画切换
        mImageView.startAnimation(AnimationSet);
        if (checkedId == R.id.btn_recommend) {
            TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo1), 0f, 0f);
            AnimationSet.addAnimation(TranslateAnimation);
            mViewPager.setCurrentItem(0);// 选择某一页

        } else if (checkedId == R.id.btn_build) {
            TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo2), 0f, 0f);
            AnimationSet.addAnimation(TranslateAnimation);
            mViewPager.setCurrentItem(1);// 选择某一页

        } else if (checkedId == R.id.btn_tutor) {
            TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo3), 0f, 0f);
            AnimationSet.addAnimation(TranslateAnimation);
            mViewPager.setCurrentItem(2);// 选择某一页

        } else if (checkedId == R.id.btn_space) {
            TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo4), 0f, 0f);
            AnimationSet.addAnimation(TranslateAnimation);
            mViewPager.setCurrentItem(3);// 选择某一页

        } else if (checkedId == R.id.btn_school) {
            TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo5), 0f, 0f);
            AnimationSet.addAnimation(TranslateAnimation);
            mViewPager.setCurrentItem(4);// 选择某一页

        } else if (checkedId == R.id.btn_show) {
            TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo6), 0f, 0f);
            AnimationSet.addAnimation(TranslateAnimation);
            mViewPager.setCurrentItem(5);// 选择某一页

        } else if (checkedId == R.id.btn_research) {
            TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo7), 0f, 0f);
            AnimationSet.addAnimation(TranslateAnimation);
            mViewPager.setCurrentItem(6);// 选择某一页

        } else if (checkedId == R.id.btn_study) {
            TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo8), 0f, 0f);
            AnimationSet.addAnimation(TranslateAnimation);
            mViewPager.setCurrentItem(7);// 选择某一页
        }else if (checkedId == R.id.btn_tool) {
            TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo9), 0f, 0f);
            AnimationSet.addAnimation(TranslateAnimation);
            mViewPager.setCurrentItem(8);// 选择某一页
        }

        //更新当前蓝色横条距离左边的距离
        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();

        Log.i("zj", "getCurrentCheckedRadioLeft=" + getCurrentCheckedRadioLeft());
        Log.i("zj", "getDimension=" + getResources().getDimension(R.dimen.rdo2));

        mHorizontalScrollView.smoothScrollTo((int) mCurrentCheckedRadioLeft - (int) getResources().getDimension(R.dimen.rdo2), 0);
    }

    /**
     * 获得当前被选中的RadioButton距离左侧的距离
     */
    private float getCurrentCheckedRadioLeft() {
        // TODO Auto-generated method stub
        if (mRadioButtonRecommend.isChecked()) {
            return getResources().getDimension(R.dimen.rdo1);
        } else if (mRadioButtonBuild.isChecked()) {
            return getResources().getDimension(R.dimen.rdo2);
        } else if (mRadioButtonTutor.isChecked()) {
            return getResources().getDimension(R.dimen.rdo3);
        } else if (mRadioButtonSpace.isChecked()) {
            return getResources().getDimension(R.dimen.rdo4);
        } else if (mRadioButtonSchool.isChecked()) {
            return getResources().getDimension(R.dimen.rdo5);
        } else if (mRadioButtonShow.isChecked()) {
            return getResources().getDimension(R.dimen.rdo6);
        } else if (mRadioButtonResearch.isChecked()) {
            return getResources().getDimension(R.dimen.rdo7);
        } else if (mRadioButtonStudy.isChecked()) {
            return getResources().getDimension(R.dimen.rdo8);
        }else if (mRadioButtonTool.isChecked()) {
            return getResources().getDimension(R.dimen.rdo9);
        }
        return 0f;
    }

    private void iniListener() {

        mRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.setAdapter(new TabAdapter(getChildFragmentManager(),mList));
        mViewPager.setOnPageChangeListener(new TabOnPageChangeListener());
    }

    private void iniController(View view) {
        //页签
        mRadioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        mRadioButtonRecommend = (RadioButton) view.findViewById(R.id.btn_recommend);
        mRadioButtonBuild = (RadioButton) view.findViewById(R.id.btn_build);
        mRadioButtonTutor = (RadioButton) view.findViewById(R.id.btn_tutor);
        mRadioButtonSpace = (RadioButton) view.findViewById(R.id.btn_space);
        mRadioButtonSchool = (RadioButton) view.findViewById(R.id.btn_school);
        mRadioButtonShow = (RadioButton) view.findViewById(R.id.btn_show);
        mRadioButtonResearch = (RadioButton) view.findViewById(R.id.btn_research);
        mRadioButtonStudy = (RadioButton) view.findViewById(R.id.btn_study);
        mRadioButtonTool = (RadioButton) view.findViewById(R.id.btn_tool);
        mImageView = (ImageView) view.findViewById(R.id.img);
        mHorizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.horizontalScrollView);
        //标题栏
        mTitle = (TextView) view.findViewById(R.id.tv_titlebar_title);
        mDes = (TextView) view.findViewById(R.id.tv_titlebar_des);
        mRecord = (TextView) view.findViewById(R.id.tv_titlebar_record);
        mDownload = (TextView) view.findViewById(R.id.tv_titlebar_download);
        mSearch = (TextView) view.findViewById(R.id.tv_titlebar_search);
        mAdress = (TextView) view.findViewById(R.id.tv_titlebar_adress);

        mDes.setVisibility(View.GONE);

        mRecord.setOnClickListener(this);
        mDownload.setOnClickListener(this);
        mSearch.setOnClickListener(this);
        mAdress.setOnClickListener(this);

        mViewPager = (ViewPager) view.findViewById(R.id.vp_homefragment_viewpager);
        mList = new ArrayList<Fragment>();
        recommend = new HomeFragment_recommend();
        bulid = new HomeFragment_build();
        tutor = new HomeFragment_tutor();
        space = new HomeFragment_space();
        school = new HomeFragment_school();
        show = new HomeFragment_show();
        research = new HomeFragment_research();
        study = new HomeFragment_study();
        tool = new HomeFragment_tool();

        //将子页面添加到集合中
        mList.add(recommend);
        mList.add(bulid);
        mList.add(tutor);
        mList.add(space);
        mList.add(school);
        mList.add(show);
        mList.add(research);
        mList.add(study);
        mList.add(tool);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_titlebar_record:
                startActivity(new Intent(getActivity().getApplicationContext(), RecordActivity.class));
                break;
            case R.id.tv_titlebar_download:
                startActivity(new Intent(getActivity().getApplicationContext(), DownloadActivity.class));
                break;
            case R.id.tv_titlebar_search:
                startActivity(new Intent(getActivity().getApplicationContext(), SearchActivity.class));
                break;
            case R.id.tv_titlebar_adress:
                startActivity(new Intent(getActivity().getApplicationContext(), LoginActivity.class));
                break;
        }
    }

    /**
     * 页卡滑动改变事件
     */
    public class TabOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /**
         * 当滑动状态改变时调用
         * state=0的时候表示什么都没做，就是停在那
         * state=1的时候表示正在滑动
         * state==2的时候表示滑动完毕了
         */
        public void onPageScrollStateChanged(int state) {

        }

        /**
         * 当前页面被滑动时调用
         * position:当前页面
         * positionOffset:当前页面偏移的百分比
         * positionOffsetPixels:当前页面偏移的像素位置
         */
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //当新的页面被选中时调用
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mRadioButtonRecommend.setChecked(true);
                    break;
                case 1:
                    mRadioButtonBuild.setChecked(true);
                    break;
                case 2:
                    mRadioButtonTutor.setChecked(true);
                    break;
                case 3:
                    mRadioButtonSpace.setChecked(true);
                    break;
                case 4:
                    mRadioButtonSchool.setChecked(true);
                    break;
                case 5:
                    mRadioButtonShow.setChecked(true);
                    break;
                case 6:
                    mRadioButtonResearch.setChecked(true);
                    break;
                case 7:
                    mRadioButtonStudy.setChecked(true);
                    break;
                case 8:
                    mRadioButtonTool.setChecked(true);
                    break;
            }
        }
    }
}
