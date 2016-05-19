package com.easemob.ChuangKeYuan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Say GoBay on 2016/5/18.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

    public TabAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    public int getCount() {
        return mFragments.size();
    }
}