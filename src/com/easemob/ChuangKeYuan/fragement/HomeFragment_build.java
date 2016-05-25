package com.easemob.ChuangKeYuan.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.easemob.ChuangKeYuan.R;
import com.easemob.ChuangKeYuan.ui.DesignActivity;
import com.easemob.ChuangKeYuan.ui.PlanActivity;
import com.easemob.ChuangKeYuan.ui.TeachActivity;


public class HomeFragment_build extends Fragment implements View.OnClickListener{

	private ImageView mImageView;
	RelativeLayout rl_build_teach,rl_build_plan,rl_build_design;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_home_build, null);
		initView(view);

		return view;
	}

	private void initView(View view) {
		mImageView = (ImageView) view.findViewById(R.id.iv_build);
		rl_build_teach = (RelativeLayout) view.findViewById(R.id.rl_build_teach);
		rl_build_plan = (RelativeLayout) view.findViewById(R.id.rl_build_plan);
		rl_build_design = (RelativeLayout) view.findViewById(R.id.rl_build_design);


		rl_build_teach.setOnClickListener(this);
		rl_build_plan.setOnClickListener(this);
		rl_build_design.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.rl_build_teach:
				startActivity(new Intent(getActivity().getApplicationContext(),TeachActivity.class));
				break;
			case R.id.rl_build_plan:
				startActivity(new Intent(getActivity().getApplicationContext(),PlanActivity.class));
				break;
			case R.id.rl_build_design:
				startActivity(new Intent(getActivity().getApplicationContext(), DesignActivity.class));
				break;
		}
	}
}

