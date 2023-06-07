package com.example.danhba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.danhba.database.databasedanhba;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewContacts;
    private Button buttonAddContact;
    private databasedanhba databaseHelper;
    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContacts = findViewById(R.id.listViewContacts);
        buttonAddContact = findViewById(R.id.buttonAddContact);

        databaseHelper = new databasedanhba(this);
        contactList = databaseHelper.getAllContacts();
        hotensvadapter adapter = new hotensvadapter(this, contactList);
        listViewContacts.setAdapter(adapter);
        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        contactList.clear();
        contactList.addAll(databaseHelper.getAllContacts());
        ((hotensvadapter)listViewContacts.getAdapter()).notifyDataSetChanged();
    }
}