package com.arafat.retrosample.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

   /* @GET("/json")
    Call<ServerResponse> getMyIp();*/

    @POST("/json")
    Call<ServerResponse>getMyIp();
}
