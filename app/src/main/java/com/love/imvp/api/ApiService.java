package com.love.imvp.api;

import com.love.imvp.mode.PolicyStatus;
import com.love.imvp.mode.UserEntity;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * 作者：zf on 2016/6/12 11:00
 * 邮箱：initzf@126.com
*/
public interface ApiService {
    @POST("member/login")
    Call<UserEntity> login(@QueryMap Map<String,String> map);

    @POST("fineUser/getPolicyStatus")
    Call<PolicyStatus> getPolicyStatus(@QueryMap Map<String,String> map);
}
