package com.jh.sh.jhsdk.service;

import android.content.Context;

import com.google.gson.JsonObject;
import com.jh.sh.jhsdk.service.base.ObserverOnNextAndErrorListener;
import com.jh.sh.jhsdk.service.base.ObserverOnNextListener;
import com.jh.sh.jhsdk.service.base.ProgressObserver;
import com.jh.sh.jhsdk.service.interceptor.HeaderInterceptor;
import com.jh.sh.jhsdk.service.interceptor.LoggingInterceptor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/27.
 * 网络请求方法封装
 */

public class HttpMethods {

    private String BASE_URL = "http://pre-i.lly800.com/Index/Api/";
    private static final int DEFAULT_TIMEOUT = 10;

    private static final HttpMethods mInstance = new HttpMethods();//单例
    private JhService service;

    //构造方法私有
    private HttpMethods() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new LoggingInterceptor())
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        service = builder.build().create(JhService.class);
    }

    //获取单例
    public static HttpMethods getInstance() {
        return mInstance;
    }

    /**
     * 业务方法
     */
    public void getHelpTypes(Context context, ObserverOnNextAndErrorListener<List<JsonObject>> observerOnNextAndErrorListener) {
        String param = "{\"uID\":\"156\",\"payType\":\"1\",\"money\":\"10\"}";
        toObserverHoolai(context, service.getHelpTypes("select_help_field", param), observerOnNextAndErrorListener);
    }

    public void getHelpTypes2(Context context, ObserverOnNextAndErrorListener<List<JsonObject>> observerOnNextAndErrorListener) {
        String url = "http://pre-i.lly800.com/Index/Api/sdk?act=select_help_field&param={%22uID%22:%22156%22,%22payType%22:%221%22,%22money%22:%2210%22}&token=55bd8e5ddaf2a6288a3ed9bed7ea4180";
        toObserverHoolai(context, service.getHelpTypes2(url), observerOnNextAndErrorListener);
    }

    /**
     * 下面两个是封装方法
     */
    private <T> void toObserver(Context context, Observable<T> observable, ObserverOnNextListener<T> observerOnNextListener) {
        toObserver(observable, new ProgressObserver<T>(context, observerOnNextListener));
    }

    private <T> void toObserver(Observable<T> observable, Observer<T> observer) {
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //只关心onNext方法
    private <T> void toObserverHoolai(Context context, Observable<JhResponse<T>> observable, ObserverOnNextListener<T> observerOnNextListener) {
        Observer<T> observer = new ProgressObserver<T>(context, observerOnNextListener);
        toObserverHoolai(observable, observer);
    }

    //只关心onNext和onError方法
    private <T> void toObserverHoolai(Context context, Observable<JhResponse<T>> observable, ObserverOnNextAndErrorListener<T> observerOnNextAndErrorListener) {
        Observer<T> observer = new ProgressObserver<T>(context, observerOnNextAndErrorListener);
        toObserverHoolai(observable, observer);
    }

    //去掉最外层包装
    private <T> void toObserverHoolai(Observable<JhResponse<T>> observable, Observer<T> observer) {
        observable
                .map(new HttpResultFunc<T>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    private static class HttpResultFunc<T> implements Function<JhResponse<T>, T> {

        @Override
        public T apply(JhResponse<T> tJhResponse) throws Exception {
            if (!tJhResponse.isSuccess()) {
                throw new JhException(tJhResponse.getCode(), new Throwable(tJhResponse.getMsg()));
            }
            return tJhResponse.getResult();
        }
    }

}
