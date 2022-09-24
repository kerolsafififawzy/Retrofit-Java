package com.kerolsmm.retrofit_java.Data;

import com.google.gson.annotations.SerializedName;

public class UserList {

        @SerializedName("id")
        public Integer id;
        @SerializedName("email")
        public String email;
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("avatar")
        public String avatar;

    }