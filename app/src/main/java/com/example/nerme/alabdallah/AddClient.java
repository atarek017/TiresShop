package com.example.nerme.alabdallah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddClient extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private EditText name;
    private EditText phone;
    private EditText details;

    private Button add;

    private ChildEventListener mChildEventListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("client");


        add = (Button) findViewById(R.id.add_Client);
        name = (EditText) findViewById(R.id.name_text);
        phone = (EditText) findViewById(R.id.phone_text);
        details = (EditText) findViewById(R.id.details_text);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addClient();
            }
        });

    }

    private void addClient() {
        String mName = name.getText().toString().trim();
        String mPhone = phone.getText().toString().trim();
        String discribtion = details.getText().toString().trim();


        if (!TextUtils.isEmpty(mName)) {

            String id = mDatabaseReference.push().getKey();

            Client client = new Client(id, mName, mPhone, discribtion);

            mDatabaseReference.child(id).setValue(client);


        } else {
            Toast.makeText(this, "Enter the name", Toast.LENGTH_LONG).show();
        }
    }
}
