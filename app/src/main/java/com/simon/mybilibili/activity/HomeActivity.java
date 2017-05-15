package com.simon.mybilibili.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.simon.mybilibili.R;
import com.simon.mybilibili.fragment.BaseFragment;
import com.simon.mybilibili.fragment.CAFrag;
import com.simon.mybilibili.fragment.DiscoveryFrag;
import com.simon.mybilibili.fragment.DynamicFrag;
import com.simon.mybilibili.fragment.PartitionFrag;
import com.simon.mybilibili.fragment.RecommendFrag;
import com.simon.mybilibili.fragment.TvOntimeFrag;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Button mTvOntimeBtn;
    private Button mRecommendBtn;
    private Button mCaBtn;
    private Button mPartitionBtn;
    private Button mDynamicBtn;
    private Button mDiscoveryBtn;
    private ArrayList<BaseFragment> mFragList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initEvent();
        initFragment();

    }

    private void initView() {
        mTvOntimeBtn = (Button) findViewById(R.id.home_btn_guide_tvontime);
        mRecommendBtn = (Button) findViewById(R.id.home_btn_guide_recommend);
        mCaBtn = (Button) findViewById(R.id.home_btn_guide_ca);
        mPartitionBtn = (Button) findViewById(R.id.home_btn_guide_partition);
        mDynamicBtn = (Button) findViewById(R.id.home_btn_guide_dynamic);
        mDiscoveryBtn = (Button) findViewById(R.id.home_btn_guide_discovery);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void initEvent() {
        mTvOntimeBtn.setOnClickListener(this);
        mRecommendBtn.setOnClickListener(this);
        mCaBtn.setOnClickListener(this);
        mPartitionBtn.setOnClickListener(this);
        mDynamicBtn.setOnClickListener(this);
        mDiscoveryBtn.setOnClickListener(this);
    }

    private void initFragment() {
        mFragList = new ArrayList<>();
        mFragList.add(new TvOntimeFrag());
        mFragList.add(new RecommendFrag());
        mFragList.add(new CAFrag());
        mFragList.add(new PartitionFrag());
        mFragList.add(new DynamicFrag());
        mFragList.add(new DiscoveryFrag());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //        if (id == R.id.nav_camera) {
        //            // Handle the camera action
        //        } else if (id == R.id.nav_gallery) {
        //
        //        } else if (id == R.id.nav_slideshow) {
        //
        //        } else if (id == R.id.nav_manage) {
        //
        //        } else if (id == R.id.nav_share) {
        //
        //        } else if (id == R.id.nav_send) {
        //
        //        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_btn_guide_tvontime:
                changeFragment(mFragList.get(0));
                break;
            case R.id.home_btn_guide_recommend:
                changeFragment(mFragList.get(1));
                break;
            case R.id.home_btn_guide_ca:
                changeFragment(mFragList.get(2));
                break;
            case R.id.home_btn_guide_partition:
                changeFragment(mFragList.get(3));
                break;
            case R.id.home_btn_guide_dynamic:
                changeFragment(mFragList.get(4));
                break;
            case R.id.home_btn_guide_discovery:
                changeFragment(mFragList.get(5));
                break;
        }
    }

    private void changeFragment(BaseFragment bf) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.home_fl_content, bf);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
