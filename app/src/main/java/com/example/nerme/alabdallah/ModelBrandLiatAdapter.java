package com.example.nerme.alabdallah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ModelBrandLiatAdapter extends ArrayAdapter<Model> {

    public ModelBrandLiatAdapter(Context context, int resource, List<Model> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.company_items, parent, false);
        }

        TextView company = (TextView) convertView.findViewById(R.id.namecompany);
        TextView model = (TextView) convertView.findViewById(R.id.modelName);


        Model message = getItem(position);


        company.setText(message.getCompany());
        model.setText(message.getName());


        return convertView;
    }
}
