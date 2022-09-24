package com.kerolsmm.retrofit_java.ViewModelApp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kerolsmm.retrofit_java.Data.ApiCreate;
import com.kerolsmm.retrofit_java.Data.UserList;
import com.kerolsmm.retrofit_java.Data.UserListModel;

import java.util.ArrayList;


import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CreateViewModel  extends AndroidViewModel {

    private final MutableLiveData<ArrayList<UserList>> GetUserList = new MutableLiveData<>();

    public CreateViewModel(@NonNull Application application) {
        super(application);
        GetUserList(application);
    }



    private void GetUserList (Context context) {
        Single<UserListModel> observable = ApiCreate.getINSTANCE(context).getUsers();
        observable.observeOn(AndroidSchedulers.mainThread())
                  .subscribeOn(Schedulers.io())
                  .subscribe(new SingleObserver<UserListModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(UserListModel userListModel) {
               GetUserList.postValue(userListModel.data);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("CreateViewModel", "onError: ", e );
            }
        });

    }


    public MutableLiveData<ArrayList<UserList>> getUserList() {
        return GetUserList;
    }



}
