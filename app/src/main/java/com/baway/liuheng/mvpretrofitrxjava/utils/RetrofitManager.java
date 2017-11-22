package com.baway.liuheng.mvpretrofitrxjava.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/11/22.
 */

public class RetrofitManager {
    private Retrofit mRetrofit;
    private  String baseUrl;
    OkHttpClient client;
    private  static RetrofitManager mRetrofitManager;
    private  RetrofitManager(){}

    public RetrofitManager(String baseUrl, OkHttpClient client) {
        this.baseUrl = baseUrl;
        this.client = client;
        initRetrofit();
    }
    public static synchronized RetrofitManager getInstance(String baseUrl,OkHttpClient client){
        if (mRetrofitManager==null){
            mRetrofitManager=new RetrofitManager(baseUrl,client);
        }
        return mRetrofitManager;
    }


    private void initRetrofit() {
        mRetrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
    public <T> T setcreate(Class<T> reqServer){
        return mRetrofit.create(reqServer);
    }
}
