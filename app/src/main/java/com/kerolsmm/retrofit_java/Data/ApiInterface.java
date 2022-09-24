package com.kerolsmm.retrofit_java.Data;


import com.google.gson.annotations.SerializedName;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("users")
    Single<UserListModel> GetListUser(@Header("Authorization") String token);

    @POST("users")
    Single<UserModel> createUser(@Header("Authorization") String token, @Body UserModel user);

    @PUT("users/{id}")
    Single<UpdateUserModel> UpdateUser(@Header("Authorization") String token,@Path("id") int id , @Body UserModel user);

    @GET("users/{id}")
    Single<ApiCreate.UserSingleApp> GetSingleUser(@Header("Authorization") String token,@Path("id") int id);

    @DELETE("users/{id}")
    Single<UserModel> DeleteUser(@Header("Authorization") String token,@Path("id") int id);

    @FormUrlEncoded
    @POST("login")
    Single<ApiCreate.TokenModel> Login (@Field("email") String email,
                                        @Field("password")  String  password );

}
