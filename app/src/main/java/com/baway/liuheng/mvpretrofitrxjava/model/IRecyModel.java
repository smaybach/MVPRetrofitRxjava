package com.baway.liuheng.mvpretrofitrxjava.model;

import com.baway.liuheng.mvpretrofitrxjava.bean.UserBean;

import rx.Observer;

/**
 * Created by lenovo on 2017/11/22.
 */

public interface IRecyModel {
    void recy(Observer<UserBean> been);


}
