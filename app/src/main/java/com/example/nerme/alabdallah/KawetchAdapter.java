package com.example.nerme.alabdallah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class KawetchAdapter extends ArrayAdapter<Model> {


    public KawetchAdapter(Context context, int resource, List<Model> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_kawetch, parent, false);
        }

        TextView company = (TextView) convertView.findViewById(R.id.company_name);
        TextView size = (TextView) convertView.findViewById(R.id.size_text_view);
        TextView model = (TextView) convertView.findViewById(R.id.model_text_view);


        Model message = getItem(position);


        company.setText(message.getCompany());
        size.setText(message.getSize());
        model.setText(message.getName());


        return convertView;
    }
}
