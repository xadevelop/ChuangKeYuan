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
import com.easemob.ChuangKeYuan.ui.ParentsActivity;
import com.easemob.ChuangKeYuan.ui.TeacherActivity;

public class HomeFragment_tutor extends Fragment implements View.OnClickListener {

    private ImageView mImageView;
    RelativeLayout rl_tutor_teacher, rl_tutor_parent;

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
        rl_tutor_teacher = (RelativeLayout) view.findViewById(R.id.rl_tutor_teacher);
        rl_tutor_parent = (RelativeLayout) view.findViewById(R.id.rl_tutor_parent);

        rl_tutor_teacher.setOnClickListener(this);
        rl_tutor_parent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_tutor_teacher:
                startActivity(new Intent(getActivity().getApplicationContext(), TeacherActivity.class));
                break;
            case R.id.rl_tutor_parent:
                startActivity(new Intent(getActivity().getApplicationContext(), ParentsActivity.class));
                break;
        }
    }

}
