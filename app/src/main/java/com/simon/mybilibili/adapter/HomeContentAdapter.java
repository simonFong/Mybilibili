package com.simon.mybilibili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.simon.mybilibili.fragment.BangumiFrag;
import com.simon.mybilibili.fragment.BaseFragment;
import com.simon.mybilibili.fragment.CategoryFrag;
import com.simon.mybilibili.fragment.DiscoveryFrag;
import com.simon.mybilibili.fragment.FollowingFrag;
import com.simon.mybilibili.fragment.HomeFrag;
import com.simon.mybilibili.fragment.LiveFrag;

import java.util.ArrayList;

/**
 * Created by simon on 2017/5/17.
 */

public class HomeContentAdapter extends FragmentPagerAdapter {

    private ArrayList<BaseFragment> mFragList;

    public HomeContentAdapter(FragmentManager fm) {
        super(fm);
        mFragList = new ArrayList<>();
        mFragList.add(new LiveFrag());
        mFragList.add(new HomeFrag());
        mFragList.add(new BangumiFrag());
        mFragList.add(new CategoryFrag());
        mFragList.add(new FollowingFrag());
        mFragList.add(new DiscoveryFrag());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragList.get(position);

    }

    @Override
    public int getCount() {
        return mFragList.size();
    }
}
