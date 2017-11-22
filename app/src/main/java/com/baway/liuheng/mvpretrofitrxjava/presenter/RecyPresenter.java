package com.baway.liuheng.mvpretrofitrxjava.presenter;

import android.content.Context;

import com.baway.liuheng.mvpretrofitrxjava.bean.UserBean;
import com.baway.liuheng.mvpretrofitrxjava.model.RecyModel;
import com.baway.liuheng.mvpretrofitrxjava.view.RecyView;

import rx.Observer;

/**
 * Created by lenovo on 2017/11/22.
 */

public class RecyPresenter {
    Context context;
    RecyModel model;
    RecyView view;

    public RecyPresenter(Context context, RecyView view) {
        this.context = context;
        this.view = view;
        model=new RecyModel();

    }

    public void show(int a){
        model.recy(new Observer<UserBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onNext(UserBean userBean) {
                view.showRecy(userBean);
            }
        });
    }
}
