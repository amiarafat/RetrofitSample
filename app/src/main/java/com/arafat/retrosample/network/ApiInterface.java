package com.arafat.retrosample.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/json")
    Call<ServerResponse> getMyIp();
}
