package com.love.imvp.api;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.love.imvp.MainApp;
import com.love.imvp.utils.NetWorkUtil;
import com.love.imvp.utils.retrofitplug.FastjsonConverterFactory;
import com.love.imvp.utils.retrofitplug.HttpLoggingInterceptor;
import com.love.imvp.utils.retrofitplug.ToStringConverterFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.schedulers.Schedulers;

public class Api {

    public static final String BASE_URL = "http://app1.ichezheng.com/CarcareService/";

    public static final int DEFAULT_TIMEOUT = 5;

    public Retrofit retrofit;
    public ApiService movieService;

    //构造方法私有
    private Api() {
        File cacheFile = new File(MainApp.getContext().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override public void log(String message) {
                Log.i("retrofit", "log: "+message);
            }
        });

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(7676, TimeUnit.MILLISECONDS)
                .connectTimeout(7676, TimeUnit.MILLISECONDS)
                .addInterceptor(logging)
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .cache(cache)
                .build();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();
        //FastjsonConverterFactory
        //GsonConverterFactory.create(gson)
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(new ToStringConverterFactory())
                .addConverterFactory(FastjsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        movieService = retrofit.create(ApiService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final Api INSTANCE = new Api();
    }

    //获取单例
    public static Api getInstance() {
        return SingletonHolder.INSTANCE;
    }


    class HttpCacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetWorkUtil.isNetConnected(MainApp.getContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Log.d("Okhttp", "no network");
            }

            Response originalResponse = chain.proceed(request);
            if (NetWorkUtil.isNetConnected(MainApp.getContext())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                        .removeHeader("Pragma")
                        .build();
            }
        }
    }
}