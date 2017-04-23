package com.jh.sh.jhsdk.service.base;

import com.jh.sh.jhsdk.service.JhException;

public interface ObserverOnNextAndErrorListener<T> {
    void onNext(T t);

    void onError(JhException e);
}
