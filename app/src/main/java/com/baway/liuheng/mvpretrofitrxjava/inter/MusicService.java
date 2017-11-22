package com.baway.liuheng.mvpretrofitrxjava.inter;

import com.baway.liuheng.mvpretrofitrxjava.bean.UserBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2017/11/22.
 */

public interface MusicService {

    @GET("iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio")
    Call<UserBean> getdata();
}
