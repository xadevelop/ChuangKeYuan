package com.easemob.ChuangKeYuan.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;
import com.easemob.ChuangKeYuan.ui.DesignActivity;
import com.easemob.ChuangKeYuan.ui.FirstTeachActivity;
import com.easemob.ChuangKeYuan.ui.PlanActivity;
import com.easemob.ChuangKeYuan.ui.TeachActivity;


public class HomeFragment_build extends Fragment implements View.OnClickListener{

	private ImageView mImageView;
	private TextView mTitle1;
	private TextView mTitle2;
	private TextView mTitle3;
	private TextView mBuildDes1;
	private TextView mBuildDes2;
	private TextView mPlanDes1;
	private TextView mPlanDes2;
	private TextView mDesignDes1;
	private TextView mDesignDes2;
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
		mTitle1 = (TextView) view.findViewById(R.id.tv_build_title1);
		mTitle2 = (TextView) view.findViewById(R.id.tv_build_title2);
		mTitle3 = (TextView) view.findViewById(R.id.tv_build_title3);

		mBuildDes1 = (TextView) view.findViewById(R.id.tv_teach_des1);
		mBuildDes2 = (TextView) view.findViewById(R.id.tv_teach_des2);

		mPlanDes1 = (TextView) view.findViewById(R.id.tv_plan_des1);
		mPlanDes2 = (TextView) view.findViewById(R.id.tv_plan_des2);

		mDesignDes1 = (TextView) view.findViewById(R.id.tv_design_des1);
		mDesignDes2 = (TextView) view.findViewById(R.id.tv_design_des2);


		mTitle1.setOnClickListener(this);
		mTitle2.setOnClickListener(this);
		mTitle3.setOnClickListener(this);

		mBuildDes1.setOnClickListener(this);
		mBuildDes2.setOnClickListener(this);

		mPlanDes1.setOnClickListener(this);
		mPlanDes2.setOnClickListener(this);

		mDesignDes1.setOnClickListener(this);
		mDesignDes2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.tv_build_title1:
				startActivity(new Intent(getActivity().getApplicationContext(),TeachActivity.class));
				break;
			case R.id.tv_build_title2:
				startActivity(new Intent(getActivity().getApplicationContext(),PlanActivity.class));
				break;
			case R.id.tv_build_title3:
				startActivity(new Intent(getActivity().getApplicationContext(), DesignActivity.class));
				break;
			case R.id.tv_teach_des1:
				startActivity(new Intent(getActivity().getApplicationContext(), FirstTeachActivity.class));
				break;
			case R.id.tv_teach_des2:
				startActivity(new Intent(getActivity().getApplicationContext(), FirstTeachActivity.class));
				break;
			case R.id.tv_plan_des1:
				startActivity(new Intent(getActivity().getApplicationContext(), FirstTeachActivity.class));
				break;
			case R.id.tv_plan_des2:
				startActivity(new Intent(getActivity().getApplicationContext(), FirstTeachActivity.class));
				break;
			case R.id.tv_design_des1:
				startActivity(new Intent(getActivity().getApplicationContext(), FirstTeachActivity.class));
				break;
			case R.id.tv_design_des2:
				startActivity(new Intent(getActivity().getApplicationContext(), FirstTeachActivity.class));
				break;
		}
	}
}

