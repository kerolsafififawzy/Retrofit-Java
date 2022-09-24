package com.kerolsmm.retrofit_java.Data;

import android.content.Context;

import com.google.gson.annotations.SerializedName;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public  class  ApiCreate {


    private final ApiInterface apiInterface;
    private final DataKey dataKey;


    public  ApiCreate (Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dataKey = new DataKey(context);
        apiInterface = retrofit.create(ApiInterface.class);


    }


    public static ApiCreate getINSTANCE(Context context) {
        return new ApiCreate(context);
    }


    public Single<UserListModel> getUsers() {
       return apiInterface.GetListUser(dataKey.GetKey());
    }

    public Single<UserSingleApp> getUser(int id) {
        return apiInterface.GetSingleUser(dataKey.GetKey() ,id);
    }

    public Single<UserModel> CreateNewUser(UserModel userModel) {
        return apiInterface.createUser(dataKey.GetKey(),userModel);
    }

    public Single<UserModel> DeleteUser(int id) {
        return apiInterface.DeleteUser(dataKey.GetKey(),id);
    }

    public Single<UpdateUserModel> UpdateUser (int  id , UserModel userModel) {
        return apiInterface.UpdateUser(dataKey.GetKey(),id,userModel);
    }

    public Single<ApiCreate.TokenModel>  login () {
        return apiInterface.Login("eve.holt@reqres.in","cityslicka");
    }



  public static class TokenModel {
        @SerializedName("token")
        public String token;
        public TokenModel() {
        }
    }
    public static class  UserSingleApp {
        @SerializedName("data")
        public UserList data = new UserList();
        public UserSingleApp () {

        }

}

}