package com.simon.mybilibili.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.simon.mybilibili.R;
import com.simon.mybilibili.controller.ActivityCollector;

/**
 * Created by simon on 2017/5/15.
 */

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {




    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    //添加一个跳转方法,有参数就加上参数,方便以后查看该Activity需要什么参数,方便阅读
    public static void actionStart(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    //侧滑栏的开启
    protected void startNavigation(NavigationView.OnNavigationItemSelectedListener listener) {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //左侧菜单的点击监听
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(listener);




    }


    //侧滑栏的点击
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                actionStart(this, HomeActivity.class);
                break;
            case R.id.nav_download:
                actionStart(this, DownloadActivity.class);
                break;
            case R.id.nav_star:
                actionStart(this, StarActivity.class);
                break;
            case R.id.nav_history:
                actionStart(this, HistoryActivity.class);
                break;
            case R.id.nav_theme:
                actionStart(this, ThemeActivity.class);
                break;
            case R.id.nav_setting:
                actionStart(this, SettingActivity.class);
                break;
        }

        if (!this.getClass().equals(HomeActivity.class)) {
            finish();
        }
        //关闭侧滑栏
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


}
