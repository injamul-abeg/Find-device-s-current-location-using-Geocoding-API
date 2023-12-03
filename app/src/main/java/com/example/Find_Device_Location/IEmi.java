package com.example.Find_Device_Location;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IEmi {
    @GET("api/emi-list/{imei}/{sl}")
    Call<WEmi> getEmiInfo(@Path("imei") String imei, @Path("sl") String sl);
}
