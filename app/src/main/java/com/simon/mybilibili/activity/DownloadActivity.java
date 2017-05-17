package com.simon.mybilibili.activity;

import android.os.Bundle;
import android.view.View;

import com.simon.mybilibili.R;

import static com.simon.mybilibili.R.id.download_toolbar_iv_back;

public class DownloadActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        initView();
        initEvent();
    }

    private void initEvent() {

    }

    private void initView() {
        findViewById(download_toolbar_iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
