package com.easemob.ChuangKeYuan.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;
import com.easemob.ChuangKeYuan.fragement.HelpFragment;
import com.easemob.ChuangKeYuan.fragement.ResponsibleFragment;

/**
 * Created by Say GoBay on 2016/5/24.
 */
public class TaskActivity extends FragmentActivity implements View.OnClickListener{

    public View view;
    public TextView mTitle;
    public TextView mDes;
    public TextView mRecord;
    public TextView mDownload;
    public TextView mSearch;
    public TextView mAdress;
    public ImageView mBack;

    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    Fragment responsibleFragment;
    Fragment helpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_task);

        initTitlebar();
        init();
        initData();
    }

    private void init() {
        fragmentManager = getSupportFragmentManager();
        radioGroup = (RadioGroup)findViewById(R.id.rg_tasktivity_radiogroup);
        ((RadioButton)radioGroup.findViewById(R.id.rbtn_tasktivity_responsible)).setChecked(true);
        transaction = fragmentManager.beginTransaction();
    }
    private void initData() {

        responsibleFragment= new ResponsibleFragment();
        helpFragment = new HelpFragment();

        transaction.replace(R.id.space, responsibleFragment);
        transaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transaction = fragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.rbtn_tasktivity_responsible:
                        transaction.replace(R.id.space, responsibleFragment);
                        break;
                    case R.id.rbtn_tasktivity_help:
                        transaction.replace(R.id.space, helpFragment);
                        break;
                }
                transaction.commit();
            }
        });
    }
    /**
     * 初始化标题栏
     */
    private void initTitlebar() {
        //标题栏
        mTitle = (TextView) findViewById(R.id.tv_titlebar_title);
        mBack = (ImageView) findViewById(R.id.iv_titlebar_back);
        mDes = (TextView) findViewById(R.id.tv_titlebar_des);
        mRecord = (TextView) findViewById(R.id.tv_titlebar_record);
        mDownload = (TextView) findViewById(R.id.tv_titlebar_download);
        mSearch = (TextView) findViewById(R.id.tv_titlebar_search);
        mAdress = (TextView) findViewById(R.id.tv_titlebar_adress);

        mTitle.setVisibility(View.GONE);
        mBack.setVisibility(View.VISIBLE);
        mDes.setVisibility(View.VISIBLE);
        mDes.setText("任务");
        mRecord.setVisibility(View.GONE);
        mDownload.setVisibility(View.GONE);
        mSearch.setVisibility(View.GONE);
        mAdress.setText("搜索");

        mBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_titlebar_back:
                finish();
                break;
            case R.id.tv_titlebar_adress:
                break;
        }
    }

}