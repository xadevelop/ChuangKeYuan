package com.easemob.ChuangKeYuan.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.easemob.ChuangKeYuan.R;
import com.easemob.ChuangKeYuan.fragement.FindFragment;
import com.easemob.ChuangKeYuan.fragement.HomeFragment;
import com.easemob.ChuangKeYuan.fragement.MyFragment;


/**
 * Created by Say GoBay on 2016/5/13.
 */
public class HomeActivity extends FragmentActivity{

    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    /**
     * 创客园子栏目
     */
    Fragment homeFragment;
    /**
     * 发现子栏目
     */
    Fragment findFragment;
    /**
     * 我的子栏目
     */
    Fragment myFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        init();
        initData();
    }

    private void init() {
        fragmentManager = getSupportFragmentManager();
        radioGroup = (RadioGroup)findViewById(R.id.rg_homeactivity_radiogroup);
        ((RadioButton)radioGroup.findViewById(R.id.rbtn_homeactivity_home)).setChecked(true);
        transaction = fragmentManager.beginTransaction();
    }

    private void initData() {

        homeFragment = new HomeFragment();
        findFragment = new FindFragment();
        myFragment = new MyFragment();

        transaction.replace(R.id.home, homeFragment);
        transaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transaction = fragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.rbtn_homeactivity_home:
                        transaction.replace(R.id.home, homeFragment);
                        break;
                    case R.id.rbtn_homeactivity_find:
                        transaction.replace(R.id.home, findFragment);
                        break;
                    case R.id.rbtn_homeactivity_my:
                        transaction.replace(R.id.home, myFragment);
                        break;
                }
                transaction.commit();
            }
        });
    }
}