package com.love.imvp.utils.retrofitplug;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 作者：zf on 2016/6/14 18:48
 * 邮箱：initzf@126.com
 */
public class FastjsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Type type;

    FastjsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String string = value.string();
        return JSON.parseObject(string, type);
    }
}