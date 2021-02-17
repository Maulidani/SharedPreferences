package com.example.testsharedpreferences.api;

import com.example.testsharedpreferences.model.ResponseUsername;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("lihat.php")
    Call<ResponseUsername> login(@Query("username") String username);
}
