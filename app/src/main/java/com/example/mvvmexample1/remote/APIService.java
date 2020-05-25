package com.example.mvvmexample1.remote;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/getList")
    Call<CatetoryList> getCatetoryList();
}
