package com.jh.sh.jhsdk.fragment.main.gift;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.sh.jhsdk.R;

import butterknife.ButterKnife;

/**
 * Created by phoenix on 2017/4/22.
 */

public class GiftRecommandFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.jh_frag_main_gift_recommand, container, false);
        ButterKnife.bind(this, baseView);
        return baseView;
    }
}
