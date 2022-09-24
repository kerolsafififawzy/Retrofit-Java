package com.kerolsmm.retrofit_java.Data;

import com.google.gson.annotations.SerializedName;

public class UpdateUserModel {

    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("updatedAt")
    public String updatedAt;

    public UpdateUserModel(String name, String job) {
        this.name = name;
        this.job = job;
    }

}
