package com.jh.sh.jhsdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by phoenix on 2017/4/22.
 */

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jh_frag_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.id_submit)
    public void onClick() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
