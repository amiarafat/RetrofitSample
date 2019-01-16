package com.arafat.retrosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.arafat.retrosample.network.ApiInterface;
import com.arafat.retrosample.network.RetrofitApiClient;
import com.arafat.retrosample.network.ServerResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMyIp();
    }

    private void showMyIp() {

        //progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<ServerResponse> call = apiInterface.getMyIp();

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

                //progressBar.setVisibility(View.GONE);

                ServerResponse sResponse = response.body();

                if(response.code() == 200 && sResponse!=null){

                    Log.d("ip::",sResponse.getIp()+"---"+sResponse.getCountryIso()+"---"+sResponse.getCountry());
                }else {

                    Log.d("ip::",response.message());
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

                //progressBar.setVisibility(View.GONE);
                Log.d("ipF:",t.getMessage());

            }
        });

    }
}
