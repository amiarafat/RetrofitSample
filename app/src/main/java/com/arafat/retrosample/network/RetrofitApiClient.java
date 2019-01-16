package com.arafat.retrosample.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {

    private static final String BASE_URL = "https://ifconfig.co/";
    private static Retrofit retrofit =null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    private RetrofitApiClient(){

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
