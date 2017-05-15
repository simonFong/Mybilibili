package com.simon.mybilibili.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simon.mybilibili.R;

/**
 * Created by simon on 2017/5/10.
 */

public class RecommendFrag extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommendlayout, null);
        return view;
    }
}
