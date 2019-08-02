package com.example.network.request.ok.func;

import com.example.network.manager.NetManager;
import com.example.network.func.IRequest;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public interface IOkHttpRequest extends IRequest {
    IOkHttpRequest addInterceptor(Interceptor interceptor);
    IOkHttpRequest addNetworkInterceptor(Interceptor interceptor);
    OkHttpClient client();

    @Override
    IOkHttpRequest newRequest(NetManager.Builder builder);
}
