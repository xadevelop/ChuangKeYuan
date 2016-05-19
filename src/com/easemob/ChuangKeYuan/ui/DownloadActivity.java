package com.easemob.ChuangKeYuan.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;


/**
 * Created by Say GoBay on 2016/5/19.
 */
public class DownloadActivity extends Activity implements View.OnClickListener {

    public View view;
    public TextView mTitle;
    public TextView mDes;
    public TextView mRecord;
    public TextView mDownload;
    public TextView mSearch;
    public TextView mAdress;
    public TextView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_download);

        initTitlebar();
    }

    /**
     * 初始化标题栏
     */
    private void initTitlebar() {
        //标题栏
        mTitle = (TextView) findViewById(R.id.tv_titlebar_title);
        mBack = (TextView) findViewById(R.id.tv_titlebar_back);
        mDes = (TextView) findViewById(R.id.tv_titlebar_des);
        mRecord = (TextView) findViewById(R.id.tv_titlebar_record);
        mDownload = (TextView) findViewById(R.id.tv_titlebar_download);
        mSearch = (TextView) findViewById(R.id.tv_titlebar_search);
        mAdress = (TextView) findViewById(R.id.tv_titlebar_adress);

        mTitle.setVisibility(View.GONE);
        mBack.setVisibility(View.VISIBLE);
        mDes.setText("下载");
        mRecord.setVisibility(View.GONE);
        mDownload.setVisibility(View.GONE);
        mSearch.setVisibility(View.GONE);
        mAdress.setText("编辑");

        mBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_titlebar_back:
                finish();
                break;
            case R.id.tv_titlebar_adress:

                break;
        }
    }
}
