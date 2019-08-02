package com.example.network.manager;

import com.example.network.func.IRequest;
import com.example.network.request.ok.OkHttpRequest;
import com.example.network.request.okgo.OkGoRequest;
import com.example.network.request.retrofit.RetrofitRequest;
import com.example.network.request.volley.VolleyRequest;
import com.example.network.request.xutils.XUtilsRequest;

public class NetRequest {
    public static IRequest okRequest() {
        return OkHttpRequest.create(NetManager.builde);
    }

    public static IRequest retrofitRequest() {
        return RetrofitRequest.create(NetManager.builde);
    }

    public static IRequest okGoRequest() {
        return OkGoRequest.create(NetManager.builde);
    }

    public static IRequest xUtilsRequest() {
        return XUtilsRequest.create(NetManager.builde);
    }

    public static IRequest volleyRequest() {
        return VolleyRequest.create(NetManager.builde);
    }
}
