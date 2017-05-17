package com.simon.mybilibili.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import com.simon.mybilibili.R;

public class StarActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        startNavigation(this);

    }


}
