package com.easemob.ChuangKeYuan.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：傅博龍  时间： 2016/5/25.
 */
public class ClassActivity_Item extends Activity {


    RelativeLayout rl_class_item;
    TextView tv_class_item;
    ListView lv_class_item;

    List data_list;

    SimpleAdapter sim_adapter;

    TextView mDes;
    ImageView mBack;
    ImageView mMore;

    // 图片封装为一个数组
    private int[] icon = { R.drawable.gv_1, R.drawable.gv_2,
            R.drawable.gv_3, R.drawable.gv_4};
    //文字封装为一个数组
    private String[] text = { "我的任务单","班级小创客","家庭工作坊","创客工作室"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_class_item);

        initView();
        event();
    }


    private void initView() {

        rl_class_item = (RelativeLayout) findViewById(R.id.rl_class_item);

        tv_class_item = (TextView) findViewById(R.id.tv_class_item);

        lv_class_item = (ListView) findViewById(R.id.lv_class_item);

        mDes = (TextView) findViewById(R.id.tv_teach_title);
        mBack = (ImageView) findViewById(R.id.iv_teach_back);
        mMore = (ImageView) findViewById(R.id.iv_teach_more);
    }
    private void event() {

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        int index = getIntent().getIntExtra("index",0);

        if (index == 0){
            rl_class_item.setBackgroundColor(0xffF9D438);
            mDes.setText("一班");
            tv_class_item.setText("我们是祖国的花朵\n是上帝的造诣");
            listviewAddData();

        }else if (index == 1){
            mDes.setText("二班");
            rl_class_item.setBackgroundColor(0xffFF8F84);
            tv_class_item.setText("我们是祖国的花朵\n是上帝的造诣");
            listviewAddData();

        }else if (index == 2){
            mDes.setText("三班");
            rl_class_item.setBackgroundColor(0xffB4DF51);
            tv_class_item.setText("我们是祖国的花朵\n是上帝的造诣");
            listviewAddData();

        }else if (index == 3){
            mDes.setText("四班");
            rl_class_item.setBackgroundColor(0xff73D9F3);
            tv_class_item.setText("我们是祖国的花朵\n是上帝的造诣");
            listviewAddData();

        }else if (index == 4){
            mDes.setText("五班");
            rl_class_item.setBackgroundColor(0xffE395E9);
            tv_class_item.setText("我们是祖国的花朵\n是上帝的造诣");
            listviewAddData();
        }else if (index == 5){
            mDes.setText("六班");
            rl_class_item.setBackgroundColor(0xffDC6681);
            tv_class_item.setText("我们是祖国的花朵\n是上帝的造诣");
            listviewAddData();
        }

    }

    private void listviewAddData() {

        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", text[i]);
            data_list.add(map);
        }
        //新建适配器
        sim_adapter = new SimpleAdapter(ClassActivity_Item.this,
                data_list, R.layout.activity_parents_listview,
                new String[]{"image","text"}, new int[]{R.id.image,R.id.text});
        //配置适配器
        lv_class_item.setAdapter(sim_adapter);
    }
}
