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
import com.easemob.ChuangKeYuan.ui.ParentsActivity;
import com.easemob.ChuangKeYuan.ui.TeacherActivity;

public class HomeFragment_tutor extends Fragment implements View.OnClickListener{

	private ImageView mImageView;
	private TextView mTitle1;
	private TextView mTitle2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_home_tutor, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		mImageView = (ImageView) view.findViewById(R.id.iv_tutor);
		mTitle1 = (TextView) view.findViewById(R.id.tv_tutor_title1);
		mTitle2 = (TextView) view.findViewById(R.id.tv_tutor_title2);

		mTitle1.setOnClickListener(this);
		mTitle2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.tv_tutor_title1:
				startActivity(new Intent(getActivity().getApplicationContext(),TeacherActivity.class));
				break;
			case R.id.tv_tutor_title2:
				startActivity(new Intent(getActivity().getApplicationContext(),ParentsActivity.class));
				break;
		}
	}

}
