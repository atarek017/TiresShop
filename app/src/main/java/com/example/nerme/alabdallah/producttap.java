package com.example.nerme.alabdallah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class producttap extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producttap);
        imageView = (ImageView) findViewById(R.id.im);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            imageView.setImageResource(bundle.getInt(String.valueOf(R.id.c1)));
        }
    }
}
