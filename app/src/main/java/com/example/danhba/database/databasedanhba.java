package com.example.danhba.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.danhba.Contact;

import java.util.ArrayList;
import java.util.List;

public class databasedanhba extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HoTenSV_Sqlite";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACTS = "Contact_TenSV";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";

    public databasedanhba(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + COLUMN_ID + " TEXT PRIMARY KEY," + COLUMN_NAME + " TEXT,"
                + COLUMN_PHONE_NUMBER + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        // Thêm 6 bản ghi mẫu vào bảng Contact_TenSV
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, "1");
        values.put(COLUMN_NAME, "Nguyen Van A");
        values.put(COLUMN_PHONE_NUMBER, "0123456789");
        db.insert(TABLE_CONTACTS, null, values);

        values = new ContentValues();
        values.put(COLUMN_ID, "2");
        values.put(COLUMN_NAME, "Tran Thi B");
        values.put(COLUMN_PHONE_NUMBER, "0987654321");
        db.insert(TABLE_CONTACTS, null, values);

        values = new ContentValues();
        values.put(COLUMN_ID, "3");
        values.put(COLUMN_NAME, "Le Van C");
        values.put(COLUMN_PHONE_NUMBER, "0123456789");
        db.insert(TABLE_CONTACTS, null, values);

        values = new ContentValues();
        values.put(COLUMN_ID, "4");
        values.put(COLUMN_NAME, "Hoang Thi D");
        values.put(COLUMN_PHONE_NUMBER, "0987654321");
        db.insert(TABLE_CONTACTS, null, values);

        values = new ContentValues();
        values.put(COLUMN_ID, "5");
        values.put(COLUMN_NAME, "Pham Van E");
        values.put(COLUMN_PHONE_NUMBER, "0123456789");
        db.insert(TABLE_CONTACTS, null, values);

        values = new ContentValues();
        values.put(COLUMN_ID, "6");
        values.put(COLUMN_NAME, "Do Thi F");
        values.put(COLUMN_PHONE_NUMBER, "0987654321");
        db.insert(TABLE_CONTACTS, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    // Lấy danh sách tất cả các Contact từ CSDL SQLite và trả về dưới dạng List<Contact_TenSV>
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS + " ORDER BY " + COLUMN_NAME + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(cursor.getString(0));
                contact.setNam(cursor.getString(1));
                contact.setPhone(cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return contactList;
    }

    // Thêm một Contact mới vào CSDL SQLite
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, contact.getId());
        values.put(COLUMN_NAME, contact.getNam());
        values.put(COLUMN_PHONE_NUMBER, contact.getPhone());
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

}
