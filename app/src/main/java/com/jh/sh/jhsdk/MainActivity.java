package com.jh.sh.jhsdk;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.jh.sh.jhsdk.fragment.main.ActFragment;
import com.jh.sh.jhsdk.fragment.main.FirstFragment;
import com.jh.sh.jhsdk.fragment.main.GiftFragment;
import com.jh.sh.jhsdk.fragment.main.QuanziFragment;


/**
 * Created by phoenix on 2017/4/22.
 */

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment firstFragment, quanziFragment, giftFragment, actFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jh_activity_main);

        fragmentManager = getSupportFragmentManager();

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.id_radio_group);
        radioGroup.setOnCheckedChangeListener(this);

        firstFragment = new FirstFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.id_frame_layout, firstFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (checkedId) {
            case R.id.id_rb_first:
                if (firstFragment == null) {
                    firstFragment = new FirstFragment();
                    fragmentTransaction.add(R.id.id_frame_layout, firstFragment);
                } else {
                    fragmentTransaction.show(firstFragment);
                }
                break;
            case R.id.id_rb_quanzi:
                if (quanziFragment == null) {
                    quanziFragment = new QuanziFragment();
                    fragmentTransaction.add(R.id.id_frame_layout, quanziFragment);
                } else {
                    fragmentTransaction.show(quanziFragment);
                }
                break;
            case R.id.id_rb_gift:
                if (giftFragment == null) {
                    giftFragment = new GiftFragment();
                    fragmentTransaction.add(R.id.id_frame_layout, giftFragment);
                } else {
                    fragmentTransaction.show(giftFragment);
                }
                break;
            case R.id.id_rb_act:
                if (actFragment == null) {
                    actFragment = new ActFragment();
                    fragmentTransaction.add(R.id.id_frame_layout, actFragment);
                } else {
                    fragmentTransaction.show(actFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    //这个方法的作用是隐藏已经存在的所有的fragment
    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (firstFragment != null) {
            fragmentTransaction.hide(firstFragment);
        }
        if (quanziFragment != null) {
            fragmentTransaction.hide(quanziFragment);
        }
        if (giftFragment != null) {
            fragmentTransaction.hide(giftFragment);
        }
        if (actFragment != null) {
            fragmentTransaction.hide(actFragment);
        }
    }
}
