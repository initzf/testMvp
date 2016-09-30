package com.love.imvp.utils.retrofitplug;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * 作者：zf on 2016/6/14 18:49
 * 邮箱：initzf@126.com
 */
public class FastjsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    private final SerializeConfig serializeConfig;

    public FastjsonRequestBodyConverter(SerializeConfig serializeConfig) {
        this.serializeConfig = serializeConfig;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value, serializeConfig));
    }
}
