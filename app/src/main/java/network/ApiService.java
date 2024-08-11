package com.example.myapp.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("login")
    Call<Response> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("users")
    Call<Response> manageUser(@Field("action") String action,
                              @Field("id") String id,
                              @Field("name") String name,
                              @Field("cedula") String cedula,
                              @Field("country") String country,
                              @Field("email") String email,
                              @Field("username") String username,
                              @Field("password") String password);
}
