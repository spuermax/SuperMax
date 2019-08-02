package com.example.network.func;

import com.example.network.manager.NetManager;

import java.util.Map;

import io.reactivex.Flowable;

public interface IRequest {
    <T> Flowable<T> postForm(Map<String, Object> params, Class<T> tClass);
    <T> Flowable<T> postForm(String path, Map<String, Object> params, Class<T> tClass);
    <T> Flowable<T> postForm(Map<String, String> headers, Map<String, Object> params, Class<T> tClass);
    <T> Flowable<T> postForm(String path, Map<String, String> headers, Map<String, Object> params, Class<T> tClass);

    <T> Flowable<T> postBody(Map<String, Object> params, Class<T> tClass);
    <T> Flowable<T> postBody(String path, Map<String, Object> params, Class<T> tClass);
    <T> Flowable<T> postBody(Map<String, String> headers, Map<String, Object> params, Class<T> tClass);
    <T> Flowable<T> postBody(String path, Map<String, String> headers, Map<String, Object> params, Class<T> tClass);

    <T> Flowable<T> get(Class<T> tClass);
    <T> Flowable<T> get(String path, Class<T> tClass);
    <T> Flowable<T> get( Map<String, String> headers, Class<T> tClass);
    <T> Flowable<T> get(String path, Map<String, String> headers, Class<T> tClass);
    <T> Flowable<T> get(Map<String, String> headers, Map<String, Object> params, Class<T> tClass);
    <T> Flowable<T> get(String path, Map<String, String> headers, Map<String, Object> params, Class<T> tClass);

    IRequest newRequest(NetManager.Builder builder);
}
