package com.example.nerme.alabdallah;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class StockList extends AppCompatActivity {


    private ChildEventListener mChildEventListener;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseDatabase;

    private ListView mMessageListView;
    private KawetchAdapter mMessageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_list);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("Stocks");

        mMessageListView = findViewById(R.id.messageListView);
        final List<Model> friendlyMessages = new ArrayList<>();
        mMessageAdapter = new KawetchAdapter(getApplicationContext(), R.layout.item_kawetch, friendlyMessages);
        mMessageListView.setAdapter(mMessageAdapter);


        viewDataInListView();


        mMessageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Model mclient = friendlyMessages.get(i);
                showUpdateDialog(mclient.getmModelId(), mclient.getName());

                friendlyMessages.clear();
                viewDataInListView();
            }
        });
    }


    private void showUpdateDialog(final String artistId, String clientName) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.activity_add_model, null);


        dialog.setView(view);

        Button edite = view.findViewById(R.id.button_ad);

        final EditText name = view.findViewById(R.id.model_text);
        final EditText company = view.findViewById(R.id.company_text);
        final EditText size = view.findViewById(R.id.size_text);


        edite.setText("Update");


        dialog.setTitle("Updating Stock " + clientName);


        final AlertDialog alertDialog = dialog.create();
        alertDialog.show();

        edite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mName = name.getText().toString().trim();
                String mCompany = company.getText().toString().trim();
                String mSize = size.getText().toString().trim();

                if (!TextUtils.isEmpty(mName)) {

                    updateArtist(artistId, mName, mCompany, mSize);
                    alertDialog.dismiss();

                } else {
                    name.setError("Name Reqired");
                    return;
                }
            }
        });


    }

    private boolean updateArtist(String id, String name, String company, String size) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Stocks").child(id);

        Model client = new Model(id, name, company, size);

        databaseReference.setValue(client);

        return true;
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
}
