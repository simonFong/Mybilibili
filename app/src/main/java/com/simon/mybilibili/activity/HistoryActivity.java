package com.simon.mybilibili.activity;

import android.os.Bundle;

import com.simon.mybilibili.R;

public class HistoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        startNavigation(this);

    }

}
