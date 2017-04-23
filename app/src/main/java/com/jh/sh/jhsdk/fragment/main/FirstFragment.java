package com.jh.sh.jhsdk.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.sh.jhsdk.R;
import com.jh.sh.jhsdk.adapter.FirstAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by phoenix on 2017/4/22.
 */

public class FirstFragment extends Fragment {

    @BindView(R.id.id_recyclerview)
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.jh_frag_main_first, container, false);
        ButterKnife.bind(this, baseView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new FirstAdapter(getActivity()));
        return baseView;
    }
}
