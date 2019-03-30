package com.example.appfromscratch3.network;

import com.example.appfromscratch3.model.ZodiacWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZodiacInterface {
    @GET("/JDVila/storybook/master/zodiac.json")
    Call<ZodiacWrapper> getZodiac();
}
