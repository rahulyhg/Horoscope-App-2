package com.example.appfromscratch3.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appfromscratch3.R;
import com.example.appfromscratch3.fragment.HoroscopeFragment;
import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {
    private ImageView zodiacImage;
    private TextView zodiacName;
    private TextView zodiacNumber;
    private String name;
    private String image;
    private String number;
    private final String ADDRESS = "https://www.astrology.com/horoscope/daily/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        initializeViews();
        getIntents();
        setViews();
    }

    private void initializeViews(){
        zodiacImage = findViewById(R.id.diplay_image);
        zodiacName = findViewById(R.id.display_name);
        zodiacNumber = findViewById(R.id.display_number);
    }

    private void getIntents(){
        name = getIntent().getStringExtra(ZodiacViewHolder.NAME);
        image = getIntent().getStringExtra(ZodiacViewHolder.IMAGE);
        number = getIntent().getStringExtra(ZodiacViewHolder.NUMBER);
    }

    private void setViews(){
        zodiacName.setText(name);
        zodiacNumber.setText(number);
        Picasso.get()
                .load(image)
                .into(zodiacImage);
    }


    public void displayHoroscope(View view){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.horoscope_fragment, HoroscopeFragment.newInstance(ADDRESS + name + ".html"))
                .addToBackStack(null)
                .commit();
    }
}
