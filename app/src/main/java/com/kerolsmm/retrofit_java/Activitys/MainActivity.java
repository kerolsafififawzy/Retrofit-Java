package com.kerolsmm.retrofit_java.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.kerolsmm.retrofit_java.Data.ApiCreate;
import com.kerolsmm.retrofit_java.Data.DataKey;
import com.kerolsmm.retrofit_java.databinding.ActivityMainBinding;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DataKey dataKey = new DataKey(this);


        binding.buttonLogin.setOnClickListener( view -> {
            binding.buttonLogin.setEnabled(false);
            ApiCreate.getINSTANCE(getApplicationContext()).login()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<ApiCreate.TokenModel>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onSuccess(ApiCreate.TokenModel token) {
                    dataKey.SaveKey(token.token);
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(MainActivity.class.getName(), "onError: ", e );
                    binding.buttonLogin.setEnabled(true);
                }
            });


        });


    }

}
