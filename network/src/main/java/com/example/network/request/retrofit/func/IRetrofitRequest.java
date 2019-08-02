package com.example.network.request.retrofit.func;

import com.example.network.manager.NetManager;
import com.example.network.func.IRequest;

import retrofit2.Retrofit;

public interface IRetrofitRequest extends IRequest {
    Retrofit client();

    @Override
    IRetrofitRequest newRequest(NetManager.Builder builder);

}
