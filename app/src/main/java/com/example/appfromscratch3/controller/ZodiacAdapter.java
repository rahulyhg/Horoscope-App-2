package com.example.appfromscratch3.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.appfromscratch3.R;
import com.example.appfromscratch3.model.Zodiac;
import com.example.appfromscratch3.view.ZodiacViewHolder;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {
    private List<Zodiac> zodiacList;

    public ZodiacAdapter(List<Zodiac> zodiacList){
        this.zodiacList = zodiacList;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.zodiac_list,
                viewGroup,
                false);
        return new ZodiacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder holder, int i) {
        holder.onBind(zodiacList.get(i));
    }

    @Override
    public int getItemCount() {
        return zodiacList.size();
    }
}
