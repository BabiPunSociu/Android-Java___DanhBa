package com.example.danhba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class hotensvadapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private List<Contact> objects;

    public hotensvadapter(Context context, List<Contact> contactList) {
        super(context, 0, contactList);
        this.context = context;
        this.objects = contactList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_danhba, parent, false);
        }
        Contact contact = objects.get(position);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewPhoneNumber = view.findViewById(R.id.textViewPhoneNumber);
        textViewName.setText(contact.getNam());
        textViewPhoneNumber.setText(contact.getPhone());
        return view;
    }
}
