package com.example.appfromscratch3.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.appfromscratch3.R;
import com.example.appfromscratch3.controller.ZodiacAdapter;
import com.example.appfromscratch3.model.ZodiacWrapper;
import com.example.appfromscratch3.model.Zodiac;
import com.example.appfromscratch3.network.RetrofitSingleton;
import com.example.appfromscratch3.network.ZodiacInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private List<Zodiac> zodiacList = new ArrayList<>();
    private static final String TAG = "TAG";
    private RecyclerView recyclerView;
    private ZodiacAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createRetrofitResponse();
        initializeView();

    }

    private void initializeView(){
        recyclerView = findViewById(R.id.recyclerview);
    }
    private void setRecyclerView(){
        adapter = new ZodiacAdapter(zodiacList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void createRetrofitResponse(){
        Retrofit retrofit = RetrofitSingleton.getInstance();

        retrofit.create(ZodiacInterface.class)
                .getZodiac()
                .enqueue(new Callback<ZodiacWrapper>() {
                    @Override
                    public void onResponse(Call<ZodiacWrapper> call, Response<ZodiacWrapper> response) {
                        Log.d(TAG, "onResponse: " + response.body().getZodiac()[0].getImage());
                        zodiacList.addAll(Arrays.asList(response.body().getZodiac()));
                        setRecyclerView();
                    }

                    @Override
                    public void onFailure(Call<ZodiacWrapper> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
