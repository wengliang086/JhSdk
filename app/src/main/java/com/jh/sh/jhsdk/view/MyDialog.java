package com.jh.sh.jhsdk.view;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.sh.jhsdk.R;

/**
 * Created by phoenix on 2017/4/23.
 */

public class MyDialog extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.jh_msg_dialog, container, false);
    }
}
