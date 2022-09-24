package com.kerolsmm.retrofit_java.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.kerolsmm.retrofit_java.ApiAdapter;
import com.kerolsmm.retrofit_java.ViewModelApp.CreateViewModel;
import com.kerolsmm.retrofit_java.databinding.ActivityShowDataBinding;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShowDataBinding binding = ActivityShowDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CreateViewModel createViewModel = new ViewModelProvider(this).get(CreateViewModel.class);
        ApiAdapter apiAdapter = new ApiAdapter(new ArrayList<>());
        binding.listApi.setAdapter(apiAdapter);
        createViewModel.getUserList().observe(this, apiAdapter::setArrayList);

    }
}