package com.example.nerme.alabdallah;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HOME extends AppCompatActivity {
    FloatingActionButton inf;
    FloatingActionButton dail;

    Button pro;
    Button cli;
    Button stock;
    Button showClients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cli = (Button) findViewById(R.id.client);
        inf = (FloatingActionButton) findViewById(R.id.fabinf);
        dail = (FloatingActionButton) findViewById(R.id.fabdail);
        stock = findViewById(R.id.stock_add_button);
        showClients = findViewById(R.id.show_client_button);

        pro=findViewById(R.id.product);

        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOME.this, StockList.class);
                startActivity(intent);
            }
        });


        showClients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HOME.this, ClientList.class);
                startActivity(intent);
            }
        });


        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HOME.this, AddStocks.class);
                startActivity(intent);
            }
        });



        cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HOME.this, BRANDS.class);
                startActivity(intent);

            }
        });


        inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, " آل عبد الله للإطارات ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });

        dail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "01012345678", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });


    }
}
