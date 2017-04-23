package com.jh.sh.jhsdk.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.jh.sh.jhsdk.R;
import com.jh.sh.jhsdk.adapter.GiftAdapter;
import com.jh.sh.jhsdk.fragment.main.gift.GiftAllFragment;
import com.jh.sh.jhsdk.fragment.main.gift.GiftMyFragment;
import com.jh.sh.jhsdk.fragment.main.gift.GiftRecommandFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by phoenix on 2017/4/22.
 */

public class GiftFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    @BindView(R.id.id_view_pager)
    ViewPager viewPager;
    @BindView(R.id.id_tab_layout)
    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.jh_frag_main_gift, container, false);
        ButterKnife.bind(this, baseView);

        List<Fragment> list = new ArrayList<>();
        list.add(new GiftRecommandFragment());
        list.add(new GiftAllFragment());
        list.add(new GiftMyFragment());
        viewPager.setAdapter(new GiftAdapter(getChildFragmentManager(), list));

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);
        return baseView;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
