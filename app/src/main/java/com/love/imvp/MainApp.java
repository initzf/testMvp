package com.love.imvp;

import android.app.Application;
import android.content.Context;

/**
 * 作者：zf on 2016/6/12 10:56
 * 邮箱：initzf@126.com
 */
public class MainApp extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext.getApplicationContext();
    }
}
