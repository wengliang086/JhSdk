package com.jh.sh.jhsdk.service;

import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

interface JhService {

    @GET("sdk")
    Observable<JhResponse<List<JsonObject>>> getHelpTypes(@Query("act") String act, @Query("param") String param);

    @GET
    Observable<JhResponse<List<JsonObject>>> getHelpTypes2(@Url String url);
}
