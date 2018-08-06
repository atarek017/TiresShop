package com.example.nerme.alabdallah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStocks extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;


    private EditText model;
    private EditText company;
    private EditText size;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_model);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("Stocks");


        add = (Button) findViewById(R.id.button_ad);
        model = (EditText) findViewById(R.id.model_text);
        company = (EditText) findViewById(R.id.company_text);
        size = (EditText) findViewById(R.id.size_text);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mModel = model.getText().toString().trim();
                String mCompany = company.getText().toString().trim();
                String mSize = size.getText().toString().trim();


                if (!TextUtils.isEmpty(mModel)) {

                    String id = mDatabaseReference.push().getKey();

                    Model kawetchData = new Model(
                            id,
                            mModel,
                            mCompany,
                            mSize);

                    mDatabaseReference.child(id).setValue(kawetchData);


                    model.setText("");
                    company.setText("");
                    size.setText("");

                } else {
                    Toast.makeText(getApplicationContext(), "Enter the name", Toast.LENGTH_LONG).show();

                }


            }

        });

    }


}
