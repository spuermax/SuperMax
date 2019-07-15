package com.developers.supermax.http.callback;

public interface ICallBack<T> {
    void success(T t);
    void failed(String msg);
}
