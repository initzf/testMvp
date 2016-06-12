package com.love.imvp.api;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * 作者：zf on 2016/6/12 16:01
 * 邮箱：initzf@126.com
 */
public class TokenInterceptor implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        final Response proceed = chain.proceed(request);
        final ResponseBody body = proceed.body();
        final BufferedSource source = body.source();
        source.request(Long.MAX_VALUE);


        return null;
    }
}
