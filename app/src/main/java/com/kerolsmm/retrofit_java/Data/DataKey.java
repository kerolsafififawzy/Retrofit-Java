package com.kerolsmm.retrofit_java.Data;

import android.content.Context;
import android.content.SharedPreferences;

public class DataKey {

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public DataKey (Context context) {
        sharedPreferences = context.getSharedPreferences("KEY",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public String  GetKey () {
        return sharedPreferences.getString("login","VAL");
    }


    public void SaveKey (String key) {
     editor.putString(key,"VAL");
     editor.apply();
    }
}
