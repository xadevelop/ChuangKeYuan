package com.easemob.ChuangKeYuan.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;

/**
 * Created by Say GoBay on 2016/5/24.
 */
public class ClassActivity extends Activity implements View.OnClickListener{

    TextView tv1,tv2,tv3,tv4,tv5,tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_class);

        initView();

    }

    private void initView() {

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(ClassActivity.this,ClassActivity_Item.class);

        switch (v.getId()){
            case R.id.tv1:
                intent.putExtra("index",0);
                startActivity(intent);

                break;
            case R.id.tv2:
                intent.putExtra("index",1);
                startActivity(intent);
                break;
            case R.id.tv3:
                intent.putExtra("index",2);
                startActivity(intent);
                break;
            case R.id.tv4:
                intent.putExtra("index",3);
                startActivity(intent);
                break;
            case R.id.tv5:
                intent.putExtra("index",4);
                startActivity(intent);
                break;
            case R.id.tv6:
                intent.putExtra("index",5);
                startActivity(intent);
                break;
        }
    }
}
