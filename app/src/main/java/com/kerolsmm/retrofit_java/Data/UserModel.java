package com.kerolsmm.retrofit_java.Data;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;

    public UserModel(String name, String job) {
        this.name = name;
        this.job = job;
    }


}