package com.jh.sh.jhsdk.service;

/**
 * Created by Administrator on 2017/3/15.
 */

public class JhException extends Exception {

    public static int NETWORK_EXCEPTION = -1;
    private int code;

    public JhException(int code, Throwable e) {
        super(e.getMessage(), e);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
