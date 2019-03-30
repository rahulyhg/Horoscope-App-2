package com.example.appfromscratch3.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.appfromscratch3.R;
import com.example.appfromscratch3.model.Zodiac;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {
    public static final String IMAGE = "image";
    public static final String NAME = "name";
    public static final String NUMBER = "number";
    private TextView zodiacName;
    private TextView zodiacNumber;
    private CardView cardView;

    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardview);
        zodiacName = itemView.findViewById(R.id.zodiac_name);
        zodiacNumber = itemView.findViewById(R.id.zodiac_number);
    }

    public void onBind(final Zodiac zodiac){
        setViews(zodiac);
        cardViewClickListener(zodiac);
    }

    private void setViews(final Zodiac zodiac){
        zodiacName.setText(zodiac.getName());
        zodiacNumber.setText(zodiac.getNumber());
    }

    private void cardViewClickListener(final Zodiac object){
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra(NAME, object.getName());
                intent.putExtra(NUMBER, object.getNumber());
                intent.putExtra(IMAGE, object.getImage());
                v.getContext().startActivity(intent);
            }
        });
    }

}
