package com.baway.liuheng.mvpretrofitrxjava.model;

import com.baway.liuheng.mvpretrofitrxjava.bean.UserBean;
import com.baway.liuheng.mvpretrofitrxjava.inter.Constant;
import com.baway.liuheng.mvpretrofitrxjava.inter.MusicService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/11/22.
 */
public class RecyModel implements IRecyModel {
    @Override
    public void recy(final Observer<UserBean> been) {
        Observable.create(new Observable.OnSubscribe<UserBean>() {
            @Override
            public void call(Subscriber<? super UserBean> subscriber) {
                Retrofit rf=new Retrofit.Builder()
                        .baseUrl(Constant.URL)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                MusicService musicService = rf.create(MusicService.class);
                Call<UserBean> getdata = musicService.getdata();
                getdata.enqueue(new Callback<UserBean>() {
                    @Override
                    public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                        UserBean body = response.body();
                        been.onNext(body);
                    }

                    @Override
                    public void onFailure(Call<UserBean> call, Throwable t) {

                    }
                });
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(been);
    }

//    @Override
//    public void recy(List<UserBean> been) {
//        Retrofit bulid=new Retrofit.Builder().baseUrl(Constant.URL)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        MusicService service = bulid.create(MusicService.class);
//        Observable<UserBean> getdata = service.getdata();
//        getdata.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .flatMap(new );
//
//    }
}