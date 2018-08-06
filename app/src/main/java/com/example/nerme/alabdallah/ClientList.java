package com.example.nerme.alabdallah;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClientList extends AppCompatActivity {

    private ChildEventListener mChildEventListener;
    private ListView mClientListView;

    private ClientAdapter mClientAdapter;
    private DatabaseReference mDatabaseReference;


    private FirebaseDatabase mFirebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("client");

        mClientListView = findViewById(R.id.client_List_view);
        final List<Client> clientList = new ArrayList<>();

        mClientAdapter = new ClientAdapter(getApplicationContext(), R.layout.client_item, clientList);
        mClientListView.setAdapter(mClientAdapter);


        viewDataInListView();


        mClientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Client mclient = clientList.get(i);
                showUpdateDialog(mclient.getId(), mclient.getName());

                clientList.clear();
                viewDataInListView();
            }
        });
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
            showAddDialog();
        }

        return super.onOptionsItemSelected(item);
    }


    private void showAddDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.activity_add_client, null);

        dialog.setView(view);

        Button edite = view.findViewById(R.id.add_Client);

        final EditText name = view.findViewById(R.id.name_text);
        final EditText phone = view.findViewById(R.id.phone_text);
        final EditText discribtion = view.findViewById(R.id.details_text);

        dialog.setTitle("Add Client");

        final AlertDialog alertDialog = dialog.create();
        alertDialog.show();

        edite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mName= name.getText().toString().trim();
                String mPhone = phone.getText().toString().trim();
                String mDisc = discribtion.getText().toString().trim();

                addClient(mName, mPhone, mDisc);

            }
        });

    }

    private void addClient(String name, String phone, String disc) {


        if (!TextUtils.isEmpty(name)) {

            String id = mDatabaseReference.push().getKey();
            Client kawetchData = new Client(
                    id,
                    name,
                    phone,
                    disc);

            mDatabaseReference.child(id).setValue(kawetchData);

        } else {
            Toast.makeText(getApplicationContext(), "Enter the name", Toast.LENGTH_LONG).show();

        }


    }




    private void showUpdateDialog(final String artistId, String clientName) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.activity_add_client, null);


        dialog.setView(view);

        Button edite = view.findViewById(R.id.add_Client);
        final EditText name = view.findViewById(R.id.name_text);
        final EditText phone = view.findViewById(R.id.phone_text);
        final EditText details = view.findViewById(R.id.details_text);
        edite.setText("Update");


        dialog.setTitle("Updating Client " + clientName);


        
        final AlertDialog alertDialog = dialog.create();
        alertDialog.show();

        edite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mName = name.getText().toString().trim();
                String mphone = phone.getText().toString().trim();
                String mdetails = details.getText().toString().trim();

                if (!TextUtils.isEmpty(mName)) {

                    updateArtist(artistId, mName, mphone, mdetails);
                    alertDialog.dismiss();

                } else {
                    name.setError("Name Reqired");
                    return;
                }
            }
        });


    }

    private boolean updateArtist(String id, String name, String phone, String details) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("client").child(id);

        Client client = new Client(id, name, phone, details);

        databaseReference.setValue(client);

        return true;
    }

    private void viewDataInListView() {
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Client friendlyMessage = dataSnapshot.getValue(Client.class);
                mClientAdapter.add(friendlyMessage);

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
