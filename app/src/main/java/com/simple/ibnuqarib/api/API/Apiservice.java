package com.simple.ibnuqarib.api.API;

import com.simple.ibnuqarib.api.Model.ModelData;
import com.simple.ibnuqarib.api.Model.ModelDataSub;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiservice {

    //query buat ngambil semua data
    @GET("lihat_data.php")
    Call<List<ModelData>> getSemuaData();

    @GET("list_sub.php")
    Call<List<ModelDataSub>> getSingleData(@Query("id_category") String id_category);
}
