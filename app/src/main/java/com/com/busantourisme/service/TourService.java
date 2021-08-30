package com.com.busantourisme.service;


import com.com.busantourisme.config.SessionInterceptor;
import com.com.busantourisme.controller.Dto.CMRespDto;
import com.com.busantourisme.model.tour.Tour;

import java.util.List;

import lombok.Getter;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public interface TourService {


    @GET("/tour/list")
    Call<CMRespDto<List<Tour>>> findAll();




    OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new SessionInterceptor()).build();

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.35.47:8080")
            .build();


    TourService service = retrofit.create(TourService.class);

}
