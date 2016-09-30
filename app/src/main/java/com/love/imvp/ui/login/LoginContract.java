package com.love.imvp.ui.login;

import com.love.imvp.base.BasePresenter;
import com.love.imvp.base.BaseView;

import java.util.Map;

/**
 * 作者：zf on 2016/6/12 11:11
        * 邮箱：initzf@126.com
        */
public class LoginContract {
    interface View extends BaseView<Present> {
        void loginError(String msg);

        void loginSuccess();
    }

    interface Present extends BasePresenter {
        void login(Map<String, String> map);
    }
}
