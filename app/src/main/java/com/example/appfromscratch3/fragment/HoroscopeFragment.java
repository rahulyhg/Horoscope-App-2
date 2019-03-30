package com.example.appfromscratch3.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.appfromscratch3.R;

public class HoroscopeFragment extends Fragment {
    public static final String ADDRESS = "address";
    private String address;

    public static HoroscopeFragment newInstance(String address){
        HoroscopeFragment horoscopeFragment = new HoroscopeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ADDRESS, address);
        horoscopeFragment.setArguments(bundle);
        return horoscopeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            address = getArguments().getString(ADDRESS);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_horoscope, container, false);

        WebView webView = rootView.findViewById(R.id.horoscope_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(address);

        return  rootView;
    }

}
