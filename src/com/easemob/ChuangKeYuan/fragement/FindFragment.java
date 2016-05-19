package com.easemob.ChuangKeYuan.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;

/**
 * Created by Say GoBay on 2016/5/17.
 */
public class FindFragment extends Fragment {

    public View view;
    public TextView mTitle;
    public TextView mDes;
    public TextView mRecord;
    public TextView mDownload;
    public TextView mSearch;
    public TextView mAdress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.from(getActivity()).inflate(R.layout.fragment_find, null);
        initTitlebar(view);
        return view;

    }

    private void initTitlebar(View view) {
        //标题栏
        mTitle = (TextView) view.findViewById(R.id.tv_titlebar_title);
        mDes = (TextView) view.findViewById(R.id.tv_titlebar_des);
        mRecord = (TextView) view.findViewById(R.id.tv_titlebar_record);
        mDownload = (TextView) view.findViewById(R.id.tv_titlebar_download);
        mSearch = (TextView) view.findViewById(R.id.tv_titlebar_search);
        mAdress = (TextView) view.findViewById(R.id.tv_titlebar_adress);

        mTitle.setVisibility(View.GONE);
        mRecord.setVisibility(View.GONE);
        mDownload.setVisibility(View.GONE);
    }
}
