package com.example.network.request.retrofit;

import com.example.network.manager.NetManager;
import com.example.network.func.IRequest;
import com.example.network.request.ok.OkHttpRequest;
import com.example.network.request.retrofit.api.RetrofitApi;
import com.example.network.request.retrofit.func.IRetrofitRequest;
import com.example.network.utils.MGson;
import com.example.network.utils.StringUtils;

import org.reactivestreams.Publisher;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitRequest implements IRetrofitRequest {
    private static RetrofitRequest request;
    private NetManager.Builder builder;
    private Retrofit retrofit;
    private RetrofitApi retrofitApi;
    public RetrofitRequest(NetManager.Builder builde) {
        this.builder = builde;
        realCreateRetrofitRequest();
    }

    private void realCreateRetrofitRequest() {
        retrofit = new Retrofit.Builder()
                .baseUrl(builder.baseUrl.endsWith("/") ? builder.baseUrl : builder.baseUrl.concat("/"))
                .client(OkHttpRequest.create(builder).client())
                .addConverterFactory(GsonConverterFactory.create(MGson.mGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofitApi = retrofit.create(RetrofitApi.class);
    }

    public static IRequest create(NetManager.Builder builde) {
        if (request == null) {
            synchronized (String.class) {
                if (request == null)
                    request = new RetrofitRequest(builde) {
                    };
            }
        }
        return request;
    }

    @Override
    public Retrofit client() {
        return retrofit;
    }

    @Override
    public <T> Flowable<T> postForm(Map<String, Object> params, Class<T> tClass) {
        return postForm(null, null, params, tClass);
    }

    @Override
    public <T> Flowable<T> postForm(String path, Map<String, Object> params, Class<T> tClass) {
        return postForm(path, null, params, tClass);
    }

    @Override
    public <T> Flowable<T> postForm(Map<String, String> headers, Map<String, Object> params, Class<T> tClass) {
        return postForm(null, headers, params, tClass);
    }

    @Override
    public <T> Flowable<T> postForm(String path, Map<String, String> headers, Map<String, Object> params, final Class<T> tClass) {
        return retrofitApi
                .requestForm(StringUtils.defaultStr(path,"")
                ,headers == null ? new HashMap<String, String>() : headers
                ,params == null ? new HashMap<String, Object>() : params).flatMap(new Function<Response<ResponseBody>, Publisher<T>>() {
                    @Override
                    public Publisher<T> apply(Response<ResponseBody> s) throws Exception {
                        T t = null;
                        String string = s.body().string();
                        if (tClass == String.class)
                            t = (T) string;
                        else
                            t = MGson.from(string,tClass);
                        return Flowable.just(t);
                    }
                });
    }

    @Override
    public <T> Flowable<T> get(String path, Map<String, String> headers, Map<String, Object> params, final Class<T> tClass) {
        return retrofitApi
                .get(StringUtils.defaultStr(path, "")
                        ,headers == null ? new HashMap<String, String>() : headers
                        ,params == null ? new HashMap<String, Object>() : params).flatMap(new Function<Response<ResponseBody>, Publisher<T>>() {
                    @Override
                    public Publisher<T> apply(Response<ResponseBody> s) throws Exception {
                        T t = null;
                        String string = s.body().string();
                        if (tClass == String.class)
                            t = (T) string;
                        else
                            t = MGson.from(string,tClass);
                        return Flowable.just(t);
                    }
                });
    }

    @Override
    public <T> Flowable<T> postBody(String path, Map<String, String> headers, Map<String, Object> params, final Class<T> tClass) {
        return retrofitApi
                .requestBody(StringUtils.defaultStr(path,"")
                        ,headers == null ? new HashMap<String, String>() : headers
                        ,params == null ? new HashMap<String, Object>() : params).flatMap(new Function<Response<ResponseBody>, Publisher<T>>() {
                    @Override
                    public Publisher<T> apply(Response<ResponseBody> s) throws Exception {
                        T t = null;
                        String string = s.body().string();
                        if (tClass == String.class)
                            t = (T) string;
                        else
                            t = MGson.from(string,tClass);
                        return Flowable.just(t);
                    }
                });
    }

    @Override
    public <T> Flowable<T> postBody(Map<String, Object> params, Class<T> tClass) {
        return postBody(null, null, params, tClass);
    }

    @Override
    public <T> Flowable<T> postBody(String path, Map<String, Object> params, Class<T> tClass) {
        return postBody(path, null, params, tClass);
    }

    @Override
    public <T> Flowable<T> postBody(Map<String, String> headers, Map<String, Object> params, Class<T> tClass) {
        return postBody(null, headers, params, tClass);
    }


    @Override
    public <T> Flowable<T> get(Class<T> tClass) {
        return get(null, null, null, tClass);
    }

    @Override
    public <T> Flowable<T> get(String path, Class<T> tClass) {
        return get(path, null, null, tClass);
    }

    @Override
    public <T> Flowable<T> get(Map<String, String> headers, Class<T> tClass) {
        return get(null, headers, null, tClass);
    }

    @Override
    public <T> Flowable<T> get(String path, Map<String, String> headers, Class<T> tClass) {
        return get(path, headers, null, tClass);
    }

    @Override
    public <T> Flowable<T> get(Map<String, String> headers, Map<String, Object> params, Class<T> tClass) {
        return get(null, headers, params, tClass);
    }


    @Override
    public IRetrofitRequest newRequest(NetManager.Builder builder) {
        return new RetrofitRequest(builder) {
        };
    }
}
