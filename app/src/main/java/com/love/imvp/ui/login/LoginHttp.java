package com.love.imvp.ui.login;

import com.love.imvp.api.Api;
import com.love.imvp.mode.UserEntity;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者：zf on 2016/6/12 17:54
 * 邮箱：initzf@126.com
 */
public class LoginHttp{

    private Logininter logininter;

    private LoginHttp() {
    }

    private static class InstanceHolder {
        private static final LoginHttp instance = new LoginHttp();
    }

    public static LoginHttp getInstance() {
        return InstanceHolder.instance;
    }

    public LoginHttp setLogininter(Logininter logininter) {
        this.logininter = logininter;
        return InstanceHolder.instance;
    }

    public interface Logininter{
        void test(UserEntity body);
    }


    public void httpLogin(Map<String,String> map){
        final Call<UserEntity> login = Api.getInstance().movieService.login(map);
        login.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                final UserEntity body = response.body();
                logininter.test(body);
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {

            }
        });
    }

}
