package com.easemob.ChuangKeYuan.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.easemob.ChuangKeYuan.R;
import com.easemob.ChuangKeYuan.ui.ClassActivity;
import com.easemob.ChuangKeYuan.ui.TaskActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment_space extends Fragment implements AdapterView.OnItemClickListener{
	//GridView
	private GridView mGridView;
	private List<Map<String, Object>> data_list;
	private SimpleAdapter sim_adapter;

	// 图片封装为一个数组
	private int[] icon = { R.drawable.gv_1, R.drawable.gv_2,
			R.drawable.gv_3, R.drawable.gv_4};
	//文字封装为一个数组
	private String[] text = { "我的任务单","班级小创客","家庭工作坊","创客工作室"};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_home_space, null);
		//初始化GridView
		initGridView(view);
		return view;
	}

	/**
	 * 初始化GridView
	 */
	private void initGridView(View view) {
		mGridView = (GridView) view.findViewById(R.id.gv);
		//新建List
		data_list = new ArrayList<Map<String, Object>>();
		//获取数据
		getData();
		//新建适配器
		String [] from ={"image","text"};
		int [] to = {R.id.image,R.id.text};
		sim_adapter = new SimpleAdapter(getContext(), data_list, R.layout.fragment_gridview_item, from, to);
		//配置适配器
		mGridView.setAdapter(sim_adapter);

		mGridView.setOnItemClickListener(this);
	}
	public List<Map<String, Object>> getData(){
		//icon和text的长度是相同的，这里任选其一都可以
		for(int i=0;i<icon.length;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", text[i]);
			data_list.add(map);
		}
		return data_list;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position){
			case 0:
				startActivity(new Intent(getActivity().getApplicationContext(), TaskActivity.class));
				break;
			case 1:
				startActivity(new Intent(getActivity().getApplicationContext(), ClassActivity.class));
				break;
			case 2:
				break;
			case 3:
				break;
		}
	}

}
