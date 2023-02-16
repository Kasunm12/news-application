package com.orelit.myapplication.api;

import com.orelit.myapplication.dto.ScienceNewsDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("news")
    Call<ScienceNewsDTO> getSubject(@Query("category") String category);
}
