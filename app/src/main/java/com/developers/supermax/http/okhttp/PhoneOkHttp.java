package com.developers.supermax.http.okhttp;

import com.blankj.utilcode.util.Utils;
import com.developers.supermax.http.func.IPhoneNetworkFunction;
import com.developers.supermax.http.okhttp.listener.PhoneOkListener;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class PhoneOkHttp implements IPhoneNetworkFunction {
    private static volatile PhoneOkHttp televisionOkHttp;
    private OkHttpClient okHttpClient;

    public static PhoneOkHttp getInstance() {
        if (televisionOkHttp == null)
            synchronized (PhoneOkHttp.class){
                if (televisionOkHttp == null){
                    televisionOkHttp = new PhoneOkHttp();
                    televisionOkHttp.init();
                }
            }
        return televisionOkHttp;
    }
    @Override
    public void init() {
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10,TimeUnit.SECONDS)//读取超时
                .writeTimeout(10,TimeUnit.SECONDS)//写入超时
                .cache(new Cache(Utils.getApp().getCacheDir(),10*1024*1024))
                .addNetworkInterceptor(new StethoInterceptor())
                .eventListener(new PhoneOkListener())
                .build();
    }

    public OkHttpClient client() {
        return okHttpClient;
    }
}
