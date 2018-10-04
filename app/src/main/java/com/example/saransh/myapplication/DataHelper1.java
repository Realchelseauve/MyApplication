package com.example.saransh.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataHelper1 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "registration_db";

    public DataHelper1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Registration1.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Registration1.TABLE_NAME);
        onCreate(db);
    }
    public List<Registration1> getAllRegistrations() {
        List<Registration1> registrations = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Registration1.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Registration1 registration = new Registration1();
                registration.setPhone(cursor.getString(cursor.getColumnIndex(Registration1.COLUMN_PHONE)));
                registration.setseverity(cursor.getString(cursor.getColumnIndex(Registration1.COLUMN_Severity)));
                registration.setfailure(cursor.getString(cursor.getColumnIndex(Registration1.COLUMN_Failure)));
                registration.setChoice(cursor.getInt(cursor.getColumnIndex(Registration1.COLUMN_CHOICE1)));
                registrations.add(registration);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return registrations;
    }
    public void update_bychoice(String text){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Registration1.COLUMN_CHOICE1,"1");
        db.update(Registration1.TABLE_NAME,values,Registration1.COLUMN_PHONE+"="+text,null);
    }
    public void initial()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE "+ Registration1.TABLE_NAME +" SET " + Registration1.COLUMN_CHOICE1 +"=" +"0");
    }
    public List<Fun> setAllRegistrations(){
        List<Fun> registrations = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String dispQuery ="SELECT "+Registration1.COLUMN_Severity+","+Registration1.COLUMN_Failure+" FROM "+Registration1.TABLE_NAME+" WHERE "+Registration1.COLUMN_CHOICE1+" ="+ "1";
        Cursor cursor=db.rawQuery(dispQuery,null);
        if(cursor.moveToFirst()){
            do {
                Fun fun= new Fun();
                fun.ip=(cursor.getString(cursor.getColumnIndex(Registration1.COLUMN_Severity)));
                fun.ds=(cursor.getString(cursor.getColumnIndex(Registration1.COLUMN_Failure)));

                registrations.add(fun);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return registrations;
    }
    public List<Fun> finalfunction(String s1)
    {
        List<Fun> registrations = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String dispQuery ="SELECT "+Registration1.COLUMN_PHONE+","+Registration1.COLUMN_Severity+","+Registration1.COLUMN_Failure+" FROM "+Registration1.TABLE_NAME+" WHERE "+Registration1.COLUMN_PHONE+" ="+ s1;
        Cursor cursor=db.rawQuery(dispQuery,null);
        if(cursor.moveToFirst()){
            do {
                Fun fun= new Fun();
                fun.ip=(cursor.getString(cursor.getColumnIndex(Registration1.COLUMN_Severity)));
                fun.ds=(cursor.getString(cursor.getColumnIndex(Registration1.COLUMN_Failure)));
                fun.ph=(cursor.getString(cursor.getColumnIndex(Registration1.COLUMN_PHONE)));
                registrations.add(fun);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return registrations;
    }

    public String insertRegistrationEntry(String phone, String severity, String failure,int choice) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Registration1.COLUMN_PHONE, phone);
        values.put(Registration1.COLUMN_Severity, severity);
        values.put(Registration1.COLUMN_Failure, failure);
        values.put(Registration1.COLUMN_CHOICE1, choice);

        // insert row
        long id = db.insert(Registration1.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return phone;
    }
}
