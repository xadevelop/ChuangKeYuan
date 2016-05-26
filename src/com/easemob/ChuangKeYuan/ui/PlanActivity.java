package com.easemob.ChuangKeYuan.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Say GoBay on 2016/5/23.
 */
public class PlanActivity extends Activity implements View.OnClickListener{

    /**
     * ListView
     */
    //定义一个动态数组
    ArrayList<HashMap<String, Object>> listItem;
    private ListView mListView;

    public TextView mTitle;
    public ImageView mMore;
    public ImageView mBack;
    ImageView iv_teach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_build_item);

        //初始化ListView
        initListView();
        //初始化标题栏
        initTitlebar();
    }

    private void initListView() {
        iv_teach = (ImageView) findViewById(R.id.iv_teach);
        mListView = (ListView) findViewById(R.id.lv_teach);
        mListView.setAdapter(new ListViewAdapter(getApplicationContext()));

        //为ListView添加点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //在LogCat中输出信息
                startActivity(new Intent(PlanActivity.this,FirstTeachActivity.class));
                Log.v("MyListViewBase", "你点击了ListView条目" + position);
            }
        });

        iv_teach.setImageResource(R.drawable.e);
    }
    //添加一个得到数据的方法，方便使用
    private ArrayList<HashMap<String, Object>> getDate() {

        listItem = new ArrayList<HashMap<String, Object>>();
        //为动态数组添加数据
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemTitle", "标题" + i );
            listItem.add(map);
        }
        return listItem;
    }

    //ListView的数据适配器
    private class ListViewAdapter extends BaseAdapter {

        //得到一个LayoutInfalter对象用来导入布局
        private LayoutInflater mInflater;

        //构造函数
        public ListViewAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            //返回数组的长度
            return getDate().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.activity_build_item_item, null);
                //得到各个控件的对象
                holder.image = (ImageView) convertView.findViewById(R.id.iv_teach_listview);
                holder.title = (TextView) convertView.findViewById(R.id.tv_teach_listview);
                //绑定ViewHolder对象
                convertView.setTag(holder);
            } else {
                //取出ViewHolder对象
                holder = (ViewHolder) convertView.getTag();
                //设置TextView显示的内容，即我们存放在动态数组中的数据
                holder.title.setText(getDate().get(position).get("ItemTitle").toString());
            }
            return convertView;
        }
    }

    //存放控件
    public final class ViewHolder {
        public ImageView image;
        public TextView title;
    }

    /**
     * 初始化标题栏
     */
    private void initTitlebar() {
        //标题栏
        mTitle = (TextView) findViewById(R.id.tv_teach_title);
        mBack = (ImageView) findViewById(R.id.iv_teach_back);
        mMore = (ImageView) findViewById(R.id.iv_teach_more);

        mBack.setOnClickListener(this);
        mMore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_teach_back:
                finish();
                break;
            case R.id.iv_teach_more:

                break;
        }
    }
}
