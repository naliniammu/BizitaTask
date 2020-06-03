package com.example.bizitatask;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("tracking/viewreport.php")
    Call<ResponseModel> getLatestNews(@Query("sources") String source);

}
