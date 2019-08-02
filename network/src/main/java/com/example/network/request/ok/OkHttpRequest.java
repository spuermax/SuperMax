package com.example.network.request.ok;

import com.example.network.manager.NetManager;
import com.example.network.request.ok.func.IOkHttpRequest;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public abstract class OkHttpRequest implements IOkHttpRequest {
    private static OkHttpRequest request;
    private NetManager.Builder builder;
    private OkHttpClient okHttpClient;
    public OkHttpRequest(NetManager.Builder builde) {
        this.builder = builde;
        realCreateOkhttpRequest();
    }

    private void realCreateOkhttpRequest() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(builder.connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(builder.readTimeout,TimeUnit.MILLISECONDS)
                .writeTimeout(builder.writeTimeout, TimeUnit.MILLISECONDS)
                .build();
    }

    public static IOkHttpRequest create(NetManager.Builder builde){
        if (request == null){
            synchronized (String.class){
                if (request == null) {
                    request = new OkHttpRequest(builde){};
                }
            }
        }
        return request;
    }

    @Override
    public <T> Flowable<T> postForm(Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> postForm(String path, Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> postForm(Map<String, String> headers, Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> postForm(String path, Map<String, String> headers, Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> postBody(Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> postBody(String path, Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> postBody(Map<String, String> headers, Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> postBody(String path, Map<String, String> headers, Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> get(Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> get(String path, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> get(Map<String, String> headers, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> get(String path, Map<String, String> headers, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> get(Map<String, String> headers, Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Flowable<T> get(String path, Map<String, String> headers, Map<String, Object> params, Class<T> tClass) {
        return null;
    }

    @Override
    public IOkHttpRequest newRequest(NetManager.Builder builder) {
        return new OkHttpRequest(builder) {
        };
    }

    @Override
    public IOkHttpRequest addInterceptor(Interceptor interceptor) {
       okHttpClient = okHttpClient.newBuilder().addInterceptor(interceptor).build();
       return this;
    }

    @Override
    public IOkHttpRequest addNetworkInterceptor(Interceptor interceptor) {
        okHttpClient = okHttpClient.newBuilder().addNetworkInterceptor(interceptor).build();
        return this;
    }

    @Override
    public OkHttpClient client() {
        return okHttpClient;
    }
}
