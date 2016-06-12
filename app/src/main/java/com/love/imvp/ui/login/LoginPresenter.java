package com.love.imvp.ui.login;

import android.util.Log;

import com.love.imvp.base.Parameter;
import com.love.imvp.mode.UserEntity;

import java.util.Map;

/**
 * 作者：zf on 2016/6/12 11:11
 * 邮箱：initzf@126.com
 */
public class LoginPresenter implements LoginContract.Present, LoginHttp.Logininter {
    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }


    @Override
    public void login(Map<String, String> map) {
        LoginHttp.getInstance().setLogininter(this).httpLogin(map);
    }


    @Override
    public void start() {

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
}
