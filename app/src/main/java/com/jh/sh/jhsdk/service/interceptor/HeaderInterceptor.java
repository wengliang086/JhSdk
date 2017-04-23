package com.jh.sh.jhsdk.service.interceptor;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/3/14.
 * 请求头拦截器
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newReq = request.newBuilder()
                .addHeader("ccc", "ddd")
                .build();

        newReq = injectParamsIntoUrl(newReq.url().newBuilder(), newReq.newBuilder());

        return chain.proceed(newReq);
    }

    // func to inject params into url
    private Request injectParamsIntoUrl(HttpUrl.Builder httpUrlBuilder, Request.Builder requestBuilder) {
        httpUrlBuilder.addQueryParameter("token", "55bd8e5ddaf2a6288a3ed9bed7ea4180");
        httpUrlBuilder.addQueryParameter("aaa", "bbb");
        requestBuilder.url(httpUrlBuilder.build());
        return requestBuilder.build();
    }
}
