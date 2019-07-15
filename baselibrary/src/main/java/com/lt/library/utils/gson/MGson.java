package com.lt.library.utils.gson;


import android.util.Log;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.StringUtils;
import com.google.gson.Gson;
import com.lt.library.BuildConfig;

import org.json.JSONException;
import org.json.JSONObject;

public class MGson {
    private static final String TAG = "MGson";

    public static final Gson gson = new Gson();

    public static <T> T fromJson(String tString, Class<T> tClass) {
        return gson.fromJson(tString, tClass);
    }

    public static String toJson(Object t) {
        String s = gson.toJson(t);
        Log.d(TAG, "toJson: " + s);
        return s;
    }

    public static <T, S> S convert(T t, Class<S> sClass) {
        return fromJson(toJson(t), sClass);
    }

    public static boolean hasKey(String jsonString, String keyString) {
        Log.d(TAG, "hasKey: "+jsonString);
        if (!isJson(jsonString))
            return false;
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return jsonObject.has(keyString);
        } catch (JSONException e) {
            if (BuildConfig.DEBUG)
                e.printStackTrace();
        }
        return false;
    }

    public static <T> T get(String jsonString, String keyString, @Nullable Class<T> tClass) {
        Log.d(TAG, "get: " + jsonString);
        if (!isJson(jsonString))
            return null;
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            if (!hasKey(jsonString, keyString))
                return null;
            Object o = jsonObject.get(keyString);
            if (tClass == null)
                return (T) o.toString();
            if (tClass.isAssignableFrom(Number.class) || tClass.equals(Character.class))
                return (T) o;
            return fromJson(o.toString(), tClass);
        } catch (JSONException e) {
            if (BuildConfig.DEBUG)
                e.printStackTrace();
        }
        return null;
    }

    private static boolean isJson(String jsonString) {
        return !StringUtils.isTrimEmpty(jsonString) && ((jsonString.startsWith("{") && jsonString.endsWith("}"))
                ||
                (jsonString.endsWith("]") && jsonString.startsWith("[")));
    }
}
