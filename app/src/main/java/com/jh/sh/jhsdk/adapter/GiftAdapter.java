package com.jh.sh.jhsdk.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by phoenix on 2017/4/23.
 */

public class GiftAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles = Arrays.asList("推荐礼包", "所有礼包", "我的礼包");

    public GiftAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
