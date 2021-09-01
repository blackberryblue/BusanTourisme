package com.com.busantourisme.service;

import com.com.busantourisme.controller.Dto.CMRespDto;
import com.com.busantourisme.model.festival.Festival;
import com.com.busantourisme.model.tour.Tour;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FestivalService {


    //메인페이지
    @GET("/festival/list")
    Call<CMRespDto<List<Festival>>> findAll();

    //Detail 화면으로 갈때
    @GET("/festival/{festivalId}")
    Call<CMRespDto<Festival>> findById(@Path("festivalId") int festivalId);



    // .addInterceptor(new SessionInterceptor()).build();
//    OkHttpClient client = new OkHttpClient.Builder()
//            .connectTimeout(1, TimeUnit.MINUTES)
//        .addInterceptor(null).build();
//



    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.35.153:8080")
//            .client(client)
            .build();


    FestivalService festivalService = retrofit.create(FestivalService.class);

}
