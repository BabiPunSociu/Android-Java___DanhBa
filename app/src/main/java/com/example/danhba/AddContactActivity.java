package com.example.danhba;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.danhba.database.databasedanhba;

public class AddContactActivity extends AppCompatActivity {
    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextPhoneNumber;
    private Button buttonAdd;
    private Button buttonBack;
    private databasedanhba databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_danhba);

        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonBack = findViewById(R.id.buttonBack);

        databaseHelper = new databasedanhba(this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString().trim();
                String name = editTextName.getText().toString().trim();
                String phoneNumber = editTextPhoneNumber.getText().toString().trim();
                if (!id.isEmpty() && !name.isEmpty() && !phoneNumber.isEmpty()) {
                    Contact contact = new Contact(id,name, phoneNumber);
                    databaseHelper.addContact(contact);
                    Toast.makeText(AddContactActivity.this, "Contact added successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddContactActivity.this, "Please enter name and phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}