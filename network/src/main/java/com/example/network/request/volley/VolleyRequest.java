package com.example.network.request.volley;

import com.example.network.manager.NetManager;
import com.example.network.func.IRequest;

import java.util.Map;

import io.reactivex.Flowable;

public abstract class VolleyRequest implements IRequest{
    private static VolleyRequest request;
    private NetManager.Builder builder;

    public static IRequest create(NetManager.Builder builde){
        if (request == null){
            synchronized (String.class){
                if (request == null)
                    request = new VolleyRequest(){};
            }
        }
        request.builder = builde;
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
    public IRequest newRequest(NetManager.Builder builder) {
        return null;
    }
}
