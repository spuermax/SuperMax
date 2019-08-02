package com.example.network.request.retrofit.api;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RetrofitApi {
    @POST("{abcdefg}")
    Flowable<Response<ResponseBody>> requestBody(@Path("abcdefg") String path, @HeaderMap Map<String,String> headers,
                                                 @Body Map<String,Object> params);
    @FormUrlEncoded
    @POST("{abcdefg}")
    Flowable<Response<ResponseBody>> requestForm(@Path("abcdefg") String path, @HeaderMap Map<String,String> headers,
                               @FieldMap Map<String,Object> params);
    @GET("{abcdefg}")
    Flowable<Response<ResponseBody>> get(@Path("abcdefg") String path, @HeaderMap Map<String,String> headers,
                       @QueryMap Map<String,Object> params);
}
