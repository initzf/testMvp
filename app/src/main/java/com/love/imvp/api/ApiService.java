package com.love.imvp.api;

import com.love.imvp.mode.PolicyStatus;
import com.love.imvp.mode.UserEntity;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 作者：zf on 2016/6/12 11:00
 * 邮箱：initzf@126.com
*/
public interface ApiService {
    @POST("member/login")
    Call<UserEntity> login(@QueryMap Map<String,String> map);

    @POST("member/login")
    Observable<UserEntity> rxLogin(@QueryMap Map<String,String> map);


    @POST("fineUser/getPolicyStatus")
    Call<PolicyStatus> getPolicyStatus(@QueryMap Map<String,String> map);

    //139.196.31.108:7003/pv?pv=
    @Headers({"Content-type:application/json"})
    @POST("http://139.196.31.108:7003/pv")
    Call<String> sendPv(@Query("pv") String json);
}
