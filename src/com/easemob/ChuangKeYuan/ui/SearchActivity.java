package com.easemob.ChuangKeYuan.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.easemob.ChuangKeYuan.R;


/**
 * Created by Say GoBay on 2016/5/19.
 */
public class SearchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);
    }
}
