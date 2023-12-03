package com.example.Find_Device_Location;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService{

    @POST("/api/mobile-info") //API endpoint URL
    Call<Root> createInfo(@Body YourRequestBody requestBody);
}
