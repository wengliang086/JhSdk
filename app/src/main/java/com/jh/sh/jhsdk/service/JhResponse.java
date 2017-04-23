package com.jh.sh.jhsdk.service;

public class JhResponse<T> {

    private int code;
    private String msg;
    private T result;

    public boolean isSuccess() {
        return 10000 == code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
