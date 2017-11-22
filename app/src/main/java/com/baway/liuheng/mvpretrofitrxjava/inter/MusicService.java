package com.baway.liuheng.mvpretrofitrxjava.inter;

import com.baway.liuheng.mvpretrofitrxjava.bean.UserBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2017/11/22.
 */

public interface MusicService {

    @GET("getVideoList.do?catalogId=402834815584e463015584e539330016")
    Call<UserBean> getdata();
}
