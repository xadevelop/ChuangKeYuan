package com.easemob.ChuangKeYuan.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.easemob.ChuangKeYuan.R;
import com.easemob.ChuangKeYuan.ui.HelpActivity;

/**
 * Created by Say GoBay on 2016/5/24.
 */
public class HelpFragment extends Fragment implements View.OnClickListener{

    private Button mHelp;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.fragment_help, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mHelp = (Button) view.findViewById(R.id.btn_help);

        mHelp.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_help:
                startActivity(new Intent(getActivity().getApplicationContext(),HelpActivity.class));
                break;
        }
    }
    }

