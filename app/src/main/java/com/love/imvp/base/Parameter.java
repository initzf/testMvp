package com.love.imvp.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：zf on 2016/6/12 15:09
 * 邮箱：initzf@126.com
 */
public class Parameter {
    private static Parameter instance;
    private static Map<String,String> map = new HashMap<>();


    private static class SingletonHolder {
        private static final Parameter INSTANCE = new Parameter();
    }

    public static Parameter getInstance(){
        return SingletonHolder.INSTANCE;
    }


    public void initMap(String userid, String session){
        map.put("userid",userid);
        map.put("session",session);
    }

    public Map getparaMap(){
        return map;
    }

}
