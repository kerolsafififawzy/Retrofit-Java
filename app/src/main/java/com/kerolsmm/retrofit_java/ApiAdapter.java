package com.kerolsmm.retrofit_java;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kerolsmm.retrofit_java.Data.UserList;


import java.util.ArrayList;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {

    ArrayList<UserList> arrayList;

    public ApiAdapter (ArrayList<UserList> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ApiViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.text_layout, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {

        UserList item  = arrayList.get(position);

        holder.textView.setText(item.id+ "\n" +item.avatar+
                                         "\n"+ item.first_name
                                         +"\n"+item.last_name
                                         + "\n" + item.email );

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ApiViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setArrayList(ArrayList<UserList> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();

    }
}
