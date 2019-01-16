package com.arafat.retrosample.Retrofit;

import com.arafat.retrosample.network.RetrofitApiClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient2 {

    private static final String BASE_URL = "http://118.179.158.170/";
    private static Retrofit retrofit =null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    private RetrofitApiClient2(){

    }

    public static Retrofit getClient(){

        if(retrofit == null){

            synchronized (RetrofitApiClient.class){

                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
        }


        return retrofit;
    }
}
