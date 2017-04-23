package com.jh.sh.jhsdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.JsonObject;
import com.jh.sh.jhsdk.service.HttpMethods;
import com.jh.sh.jhsdk.service.JhException;
import com.jh.sh.jhsdk.service.base.ObserverOnNextAndErrorListener;
import com.jh.sh.jhsdk.util.DialogUtil;
import com.jh.sh.jhsdk.util.LogUtil;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jh_frag_login);
        ButterKnife.bind(this);
        findViewById(R.id.id_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    @OnClick(R.id.id_register)
    public void register() {
        DialogUtil.showDialog(this, "");
    }

    @OnClick(R.id.id_forget_pwd)
    public void forgetPwd() {
        HttpMethods.getInstance().getHelpTypes(this, new ObserverOnNextAndErrorListener<List<JsonObject>>() {
            @Override
            public void onNext(List<JsonObject> jsonObjects) {
                for (JsonObject obj : jsonObjects) {
                    LogUtil.d(obj.toString());
                }
            }

            @Override
            public void onError(JhException e) {

            }
        });
        HttpMethods.getInstance().getHelpTypes2(this, new ObserverOnNextAndErrorListener<List<JsonObject>>() {
            @Override
            public void onNext(List<JsonObject> jsonObjects) {
                for (JsonObject obj : jsonObjects) {
                    LogUtil.d(obj.toString());
                }
            }

            @Override
            public void onError(JhException e) {

            }
        });
    }
}

