package com.example.nerme.alabdallah;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class COMPANIES extends AppCompatActivity {

    String brandNumber;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;


    private ChildEventListener mChildEventListener;

    private ListView mMessageListView;
    private ModelBrandLiatAdapter mMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies);

        Intent intent = getIntent();
        brandNumber = intent.getStringExtra(BRANDS.BRANDNUMBER);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("brand" + brandNumber);


        mMessageListView = findViewById(R.id.lv);
        final List<Model> friendlyMessages = new ArrayList<>();
        mMessageAdapter = new ModelBrandLiatAdapter(getApplicationContext(), R.layout.company_items, friendlyMessages);
        mMessageListView.setAdapter(mMessageAdapter);


        viewDataInListView();
    }


    private void viewDataInListView() {

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Model friendlyMessage = dataSnapshot.getValue(Model.class);
                mMessageAdapter.add(friendlyMessage);

            }

            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        };

        mDatabaseReference.addChildEventListener(mChildEventListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.meue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            showDialog();
        }

        return super.onOptionsItemSelected(item);
    }


    private void showDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.activity_add_model, null);

        dialog.setView(view);

        Button edite = view.findViewById(R.id.button_ad);

        final EditText name = view.findViewById(R.id.model_text);
        final EditText company = view.findViewById(R.id.company_text);
        final EditText size = view.findViewById(R.id.size_text);

        dialog.setTitle("Add Company");

        final AlertDialog alertDialog = dialog.create();
        alertDialog.show();

        edite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mModel = name.getText().toString().trim();
                String mCompany = company.getText().toString().trim();
                String mSize = size.getText().toString().trim();

                addModel(mModel, mCompany, mSize);

            }
        });

    }

    private void addModel(String name, String company, String size) {


        if (!TextUtils.isEmpty(name)) {

            String id = mDatabaseReference.push().getKey();
            Model kawetchData = new Model(
                    id,
                    name,
                    company,
                    size);

            mDatabaseReference.child(id).setValue(kawetchData);

        } else {
            Toast.makeText(getApplicationContext(), "Enter the name", Toast.LENGTH_LONG).show();

        }


    }


}
