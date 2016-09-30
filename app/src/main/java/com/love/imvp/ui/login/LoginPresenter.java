package com.love.imvp.ui.login;

import android.util.Log;

import com.love.imvp.base.Parameter;
import com.love.imvp.mode.UserEntity;

import java.util.Map;

import rx.functions.Action1;

/**
 * 作者：zf on 2016/6/12 11:11
 * 邮箱：initzf@126.com
 */
public class LoginPresenter implements LoginHttp.Logininter, LoginContract.Present {
    private static final String TAG = "LoginPresenter";
    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }


    @Override
    public void login(Map<String, String> map) {

        Action1<UserEntity> action1 = new Action1<UserEntity>() {
            @Override
            public void call(UserEntity body) {
                Log.i(TAG, "call: "+body);
                final int errFlag = body.getErrFlag();
                if (errFlag == 1) {
                    Parameter.getInstance().initMap(String.valueOf(body.getUserid()), body.getSession());
                    view.loginSuccess();
                } else {
                    view.loginError(body.getErrMsg());
                }
           }
        };

        LoginHttp.getInstance().getRxData(map,action1);
    }


    @Override
    public void test(UserEntity body) {
        if (body != null) {
            Log.i("xxxxxxxxxxxxxx", "test: " + body.toString());
            final int errFlag = body.getErrFlag();
            if (errFlag == 1) {
                Parameter.getInstance().initMap(String.valueOf(body.getUserid()), body.getSession());
                view.loginSuccess();
            } else {
                view.loginError(body.getErrMsg());
            }
        }
    }

    @Override
    public void start() {

    }
}
