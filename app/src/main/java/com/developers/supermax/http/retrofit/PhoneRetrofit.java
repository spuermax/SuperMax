package com.developers.supermax.http.retrofit;

import com.developers.supermax.http.func.IPhoneNetworkFunction;
import com.developers.supermax.http.okhttp.PhoneOkHttp;
import com.lt.library.utils.gson.MGson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhoneRetrofit implements IPhoneNetworkFunction {
    private static PhoneRetrofit televisionRetrofit;
    private Retrofit mRetrofit;

    public static PhoneRetrofit getInstance() {
        if (televisionRetrofit == null)
            synchronized (PhoneRetrofit.class){
                if (televisionRetrofit == null) {
                    televisionRetrofit = new PhoneRetrofit();
                    televisionRetrofit.init();
                }
            }
        return televisionRetrofit;
    }

    @Override
    public void init() {
        mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(MGson.gson))
                .baseUrl("https://www.baidu.com/")
                .client(PhoneOkHttp.getInstance().client())
                .build();
    }
    public Retrofit client(){
        return mRetrofit;
    }

    public final <T> T create(Class<T> tClass){
        return mRetrofit.create(tClass);
    }
}
