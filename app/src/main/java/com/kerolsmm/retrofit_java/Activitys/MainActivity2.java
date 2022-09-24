package com.kerolsmm.retrofit_java.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kerolsmm.retrofit_java.Data.ApiCreate;
import com.kerolsmm.retrofit_java.Data.ApiInterface;
import com.kerolsmm.retrofit_java.Data.UpdateUserModel;
import com.kerolsmm.retrofit_java.Data.UserModel;
import com.kerolsmm.retrofit_java.R;
import com.kerolsmm.retrofit_java.databinding.ActivityMain2Binding;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    private final String TAG = "MainActivity2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.GetUser.setOnClickListener(this);
        binding.GetUserList.setOnClickListener(this);
        binding.Post.setOnClickListener(this);
        binding.Delete.setOnClickListener(this);
        binding.Put.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.Delete) {
            CreateObserver();
        }else if (id == R.id.Put) {
            UpdateObserver();
        }else if (id == R.id.Post) {
            CreateObserver();
        }else if (id == R.id.Get_user) {
            GetUserObserver();
        }else if (id == R.id.Get_userList) {
            Intent intent = new Intent(getApplicationContext(),ShowDataActivity.class);
            startActivity(intent);
        }

     }

    public void UpdateObserver () {
        Single<UpdateUserModel> observable = ApiCreate.getINSTANCE(getApplicationContext()).UpdateUser(1,new UserModel("morpheus","zion residen"));
        SingleObserver<UpdateUserModel> observer = new SingleObserver<UpdateUserModel>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(UpdateUserModel updateUserModel) {
                Log.d(TAG, "onNext: " + updateUserModel.updatedAt + "--" + updateUserModel.name);
            }


            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ",e);
            }

        };

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    public void CreateObserver () {
        Single<UserModel> observable = ApiCreate.getINSTANCE(getApplicationContext()).DeleteUser(1);
        SingleObserver<UserModel> observer = new SingleObserver<UserModel>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(UserModel userModel) {
                Log.d(TAG, "onNext: " + userModel.createdAt + "--" + userModel.name);
            }


            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ",e);
            }

            };

         observable.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(observer);

    }

    public void GetUserObserver () {
        Single<ApiCreate.UserSingleApp> observable = ApiCreate.getINSTANCE(getApplicationContext()).getUser(1);
        SingleObserver<ApiCreate.UserSingleApp> observer = new SingleObserver<ApiCreate.UserSingleApp>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(ApiCreate.UserSingleApp userList) {
                Log.d(TAG, "onNext: " + userList.data.email + "--" + userList.data.id);
            }


            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ",e);
            }

        };

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);

    }


}