package com.com.busantourisme.service;

import com.com.busantourisme.controller.Dto.CMRespDto;
import com.com.busantourisme.controller.Dto.JoinDto;
import com.com.busantourisme.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {


    //회원가입
    @POST
    Call<CMRespDto<User>> join(@Body JoinDto joinDto);

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.35.225:8080")
            .build();

    UserService service = retrofit.create(UserService.class);
}
