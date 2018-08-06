package com.example.nerme.alabdallah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ClientAdapter extends ArrayAdapter<Client> {

    public ClientAdapter(Context context, int resource, List<Client> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.client_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.pesrdon_name);
        TextView phone = (TextView) convertView.findViewById(R.id.phone);


        Client message = getItem(position);


        name.setText(message.getName());
        phone.setText(message.getPhone());


        return convertView;
    }
}
