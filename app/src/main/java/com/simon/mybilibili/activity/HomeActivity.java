package com.simon.mybilibili.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.simon.mybilibili.R;
import com.simon.mybilibili.adapter.HomeContentAdapter;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Button mTvOntimeBtn;
    private Button mRecommendBtn;
    private Button mCaBtn;
    private Button mPartitionBtn;
    private Button mDynamicBtn;
    private Button mDiscoveryBtn;

    private DrawerLayout mDrawer;
    private ViewPager mHomeContentVp;
    private HomeContentAdapter mHomeContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initEvent();
        //启动侧滑栏
        startNavigation(this);

    }

    private void initView() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mTvOntimeBtn = (Button) findViewById(R.id.home_btn_guide_tvontime);
        mRecommendBtn = (Button) findViewById(R.id.home_btn_guide_recommend);
        mCaBtn = (Button) findViewById(R.id.home_btn_guide_ca);
        mPartitionBtn = (Button) findViewById(R.id.home_btn_guide_partition);
        mDynamicBtn = (Button) findViewById(R.id.home_btn_guide_dynamic);
        mDiscoveryBtn = (Button) findViewById(R.id.home_btn_guide_discovery);
        mHomeContentVp = (ViewPager) findViewById(R.id.home_vp_content);
        mHomeContentAdapter = new HomeContentAdapter(getSupportFragmentManager());
        mHomeContentVp.setAdapter(mHomeContentAdapter);

        //点击登录
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_home);
        headerView.findViewById(R.id.nav_header_home_img_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionStart(HomeActivity.this, LoginActivity.class);
            }
        });

        headerView.findViewById(R.id.nav_header_home_tv_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionStart(HomeActivity.this, LoginActivity.class);
            }
        });

        //点击首页头像跟文字弹出侧滑栏
        findViewById(R.id.home_toolbar_iv_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.openDrawer(GravityCompat.START);
            }
        });
        findViewById(R.id.home_toolbar_tv_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.openDrawer(GravityCompat.START);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //有这个就会显示的是原生ActionBar的信息
        setSupportActionBar(toolbar);


        //这是右下角的按钮
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出一个类似吐司的信息框,可以右滑消除
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });


    }


    private void initEvent() {
        mTvOntimeBtn.setOnClickListener(this);
        mRecommendBtn.setOnClickListener(this);
        mCaBtn.setOnClickListener(this);
        mPartitionBtn.setOnClickListener(this);
        mDynamicBtn.setOnClickListener(this);
        mDiscoveryBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_btn_guide_tvontime:
                mHomeContentVp.setCurrentItem(0, true);
                break;
            case R.id.home_btn_guide_recommend:
                mHomeContentVp.setCurrentItem(1, true);
                break;
            case R.id.home_btn_guide_ca:
                mHomeContentVp.setCurrentItem(2, true);
                break;
            case R.id.home_btn_guide_partition:
                mHomeContentVp.setCurrentItem(3, true);
                break;
            case R.id.home_btn_guide_dynamic:
                mHomeContentVp.setCurrentItem(4, true);
                break;
            case R.id.home_btn_guide_discovery:
                mHomeContentVp.setCurrentItem(5, true);
                break;
        }
    }


    //按返回键
    @Override
    public void onBackPressed() {

        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //按菜单键
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
