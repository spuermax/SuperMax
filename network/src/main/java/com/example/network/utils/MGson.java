package com.example.network.utils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MGson {
    public static final Gson mGson = new Gson();
    public static String toJson(Object o){
        return mGson.toJson(o);
    }
    public static <T> T from(String jsonString,Class<T> tClass){
        return mGson.fromJson(jsonString,tClass);
    }
    public static <T> T get(String jsonString,String key,Class<T> tClass){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            boolean has = jsonObject.has(key);
            if (!has)
                return null;
            return (T) jsonObject.get(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
