package com.love.imvp.ui.login;

import android.util.Log;

import com.love.imvp.api.Api;
import com.love.imvp.mode.UserEntity;

import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
        /*final Call<UserEntity> login = Api.getInstance().movieService.login(map);
        login.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                final UserEntity body = response.body();
                logininter.test(body);
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {

            }
        });*/
    }


    private void rxLogin(Map<String,String> map){
        final Observable<UserEntity> userEntityObservable = Api.getInstance().movieService.rxLogin(map);
        userEntityObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserEntity>() {
                    @Override
                    public void call(UserEntity entity) {
                        Log.i("xxx", "call: "+entity);
                        logininter.test(entity);
                    }
                });
    }

    public void getRxData(Map<String,String> map,Subscriber<UserEntity> subscriber){
        Api.getInstance().movieService.rxLogin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }
    public void getRxData(Map<String,String> map, Action1<UserEntity> action1){
        Api.getInstance().movieService.rxLogin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(action1);
    }

}
