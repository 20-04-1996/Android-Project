package com.dholakiya.pankaj.databasepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseClass {

    MyDBClass myDBClass;

    public MyDatabaseClass(Context context) {

        myDBClass = new MyDBClass(context);

    }



    static class MyDBClass extends SQLiteOpenHelper {

        private static final String DB_Name = "Contact";
        private static final String Table_Name = "Contact_Detail";
        private static final String UID = "_id";
        private static final String Name = "Name";
        private static final String Email = "Email";
        private static final String Address = "Address";
        private static final String Gender = "Gender";
        private static final int Database_Version = 5;

        private static final String Create_Table = "CREATE TABLE " + Table_Name + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Name + " VARCHAR(225), "
                + Email + " VARCHAR(225), "
                + Address + " VARCHAR(225), "
                + Gender + " VARCHAR(225))";
        private static final String Drop_Table = "DROP TABLE IF EXISTS " + Table_Name;

        Context context;


        public MyDBClass(Context context) {

            super(context, DB_Name, null, Database_Version);
            this.context = context;

        }

        public static String getTable_Name() {
            return Table_Name;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

                db.execSQL(Create_Table);

            } catch (SQLException e) {
                Toast.makeText(context, " " + e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try {

                db.execSQL(Drop_Table);

                onCreate(db);


            } catch (SQLException s) {
                Toast.makeText(context, " " + s, Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void add() {
        TableDetail tableDetail = new TableDetail();
        SQLiteDatabase database = myDBClass.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyDBClass.Name, tableDetail.getName());
        values.put(MyDBClass.Name, tableDetail.getEmail());
        values.put(MyDBClass.Name, tableDetail.getAddress());
        values.put(MyDBClass.Name, tableDetail.getGender());

        database.insert(MyDBClass.Table_Name, null, values);
    }

    public void insert(String name, String email, String address, String gender) {

        SQLiteDatabase database = myDBClass.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MyDBClass.Name, name);
        values.put(MyDBClass.Email, email);
        values.put(MyDBClass.Address, address);
        values.put(MyDBClass.Gender, gender);

        database.insert(MyDBClass.Table_Name, null, values);


    }


}
