package com.love.imvp.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * 作者：zf on 2016/6/23 09:52
 * 邮箱：initzf@126.com
 */
public class NotificeService extends Service {
    private static final String TAG = "NotificeService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        try{
            Log.i(TAG, "onCreate: ");
            if(Build.VERSION.SDK_INT<18){
                startForeground(1120,new Notification());
            }
        }catch (Exception e){
            Log.i(TAG, "Exception: ");
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    private void debugLog(){
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Log.i(TAG, "call: "+aLong);
            }
        });
    }
}
