package com.love.imvp.ui.home;

import com.love.imvp.base.BasePresenter;
import com.love.imvp.base.BaseView;

import java.util.Map;

/**
 * 作者：zf on 2016/6/12 14:43
 * 邮箱：initzf@126.com
 */
public class IndexContract {
    interface View extends BaseView<Present>{
        void userPolicy(int status);
    }

    interface Present extends BasePresenter{
        void getPolicyStatus(Map<String, String> map);

        void sendPv();
    }
}
