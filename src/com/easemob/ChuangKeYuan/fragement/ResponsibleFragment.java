package com.easemob.ChuangKeYuan.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.easemob.ChuangKeYuan.R;
import com.easemob.ChuangKeYuan.ui.ResponsibleActivity;

/**
 * Created by Say GoBay on 2016/5/24.
 */
public class ResponsibleFragment extends Fragment implements View.OnClickListener{
    private Button mResponsible;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.fragment_responsible, null);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mResponsible = (Button) view.findViewById(R.id.btn_responsible);

        mResponsible.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_responsible:
                startActivity(new Intent(getActivity().getApplicationContext(),ResponsibleActivity.class));
                break;
        }
    }
}
