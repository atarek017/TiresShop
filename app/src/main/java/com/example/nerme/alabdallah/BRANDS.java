package com.example.nerme.alabdallah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class BRANDS extends AppCompatActivity {
    ///////////////////////
    CardView c1;
    CardView c2;
    CardView c3;
    CardView c4;
    CardView c5;
    CardView c6;
    CardView c7;
    CardView c8;
    CardView c9;
    CardView c10;

    ///////////////////////

    public static final String BRANDNUMBER = "prandnumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands);
        /////////////////////////////////////
        c1 = ((CardView) findViewById(R.id.c1));
        c2 = ((CardView) findViewById(R.id.c2));
        c3 = ((CardView) findViewById(R.id.c3));
        c4 = ((CardView) findViewById(R.id.c4));
        c5 = ((CardView) findViewById(R.id.c5));
        c6 = ((CardView) findViewById(R.id.c6));
        c7 = ((CardView) findViewById(R.id.c7));
        c8 = ((CardView) findViewById(R.id.c8));
        c9 = ((CardView) findViewById(R.id.c9));
        c10 = ((CardView) findViewById(R.id.c10));
        //////////////////////////////////////
        //////////////////////////////////////
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "1");
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "2");
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "3");
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "4");
                startActivity(intent);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "5");
                startActivity(intent);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "6");
                startActivity(intent);
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "7");
                startActivity(intent);
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "8");
                startActivity(intent);
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "9");

                startActivity(intent);
            }
        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BRANDS.this, COMPANIES.class);
                intent.putExtra(BRANDNUMBER, "10");

                startActivity(intent);
            }
        });

    }
}
