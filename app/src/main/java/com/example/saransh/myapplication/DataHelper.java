package com.example.saransh.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DataHelper extends SQLiteOpenHelper {
        // Database Version

        private static final int DATABASE_VERSION = 2;
        private static final String DATABASE_NAME = "registration_db";

        public DataHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        // Creating Tables


        // Creating Tables
        @Override
        public void onCreate(SQLiteDatabase db) {

            // create notes table
            db.execSQL(Registration.CREATE_TABLE);
        }



        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            // Drop older table if existed
            db.execSQL("DROP TABLE IF EXISTS " + Registration.TABLE_NAME);

            // Create tables again
            onCreate(db);
        }
        public void initial(String text){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(Registration.COLUMN_CHOICE,"0");
            db.update(Registration.TABLE_NAME,values,Registration.COLUMN_PHONE+"="+text,null);
        }
        public void update_byphone(String text){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(Registration.COLUMN_CHOICE,"1");
            db.update(Registration.TABLE_NAME,values,Registration.COLUMN_PHONE+"="+text,null);
    }
    public void update_bydslam(String text){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Registration.COLUMN_CHOICE,1);
        db.update(Registration.TABLE_NAME,values,Registration.COLUMN_DSLAM+"="+text,null);
    }
        public String insertRegistrationEntry(String phone, String dslam, int choice) {
            // get writable database as we want to write data
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            // `id` and `timestamp` will be inserted automatically.
            // no need to add them
            values.put(Registration.COLUMN_PHONE, phone);
            values.put(Registration.COLUMN_DSLAM, dslam);
            values.put(Registration.COLUMN_CHOICE, choice);

            // insert row
            long id = db.insert(Registration.TABLE_NAME, null, values);

            // close db connection
            db.close();

            // return newly inserted row id
            return phone;
        }
        public Registration getRegistrationEntry(String phone) {
            // get readable database as we are not inserting anything
            SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Registration.TABLE_NAME,
                new String[]{Registration.COLUMN_PHONE, Registration.COLUMN_DSLAM, Registration.COLUMN_CHOICE},
                Registration.COLUMN_PHONE + "=?",
                new String[]{phone}, null, null, null, null);
            if (cursor != null)
                cursor.moveToFirst();

            // prepare registration object
            Registration registration = new Registration(
                    cursor.getString(cursor.getColumnIndex(Registration.COLUMN_PHONE)),
                    cursor.getString(cursor.getColumnIndex(Registration.COLUMN_DSLAM)),
                    cursor.getInt(cursor.getColumnIndex(Registration.COLUMN_CHOICE)));

            // close the db connection
            cursor.close();

            return registration;
        }
        //To display Required output
    public List<Fun>setAllRegistrations(){
        List<Fun> registrations = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String dispQuery ="SELECT "+Registration.COLUMN_PHONE+","+Registration.COLUMN_DSLAM+" FROM "+Registration.TABLE_NAME+" WHERE "+Registration.COLUMN_CHOICE+" ="+ "1";
        Cursor cursor=db.rawQuery(dispQuery,null);
if(cursor.moveToFirst()){
    do {
        Fun fun= new Fun();
        fun.ip=(cursor.getString(cursor.getColumnIndex(Registration.COLUMN_PHONE)));
        fun.ds=(cursor.getString(cursor.getColumnIndex(Registration.COLUMN_DSLAM)));

        registrations.add(fun);
    } while (cursor.moveToNext());
}

        // close db connection
        db.close();

        // return notes list
        return registrations;
    }
public String removeds(String text){
            Fun fun=new Fun();
            SQLiteDatabase db=this.getReadableDatabase();
    String remQuery ="SELECT "+Registration.COLUMN_DSLAM+" FROM "+Registration.TABLE_NAME+" WHERE "+Registration.COLUMN_PHONE+" ="+ text;
    Cursor cursor=db.rawQuery(remQuery,null);
    fun.ds=(cursor.getString(cursor.getColumnIndex(Registration.COLUMN_DSLAM)));
    return fun.ds;
}

        public List<Registration> getAllRegistrations() {
            List<Registration> registrations = new ArrayList<>();

            // Select All Query
            String selectQuery = "SELECT  * FROM " + Registration.TABLE_NAME;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Registration registration = new Registration();
                    registration.setPhone(cursor.getString(cursor.getColumnIndex(Registration.COLUMN_PHONE)));
                    registration.setDslam(cursor.getString(cursor.getColumnIndex(Registration.COLUMN_DSLAM)));
                    registration.setChoice(cursor.getInt(cursor.getColumnIndex(Registration.COLUMN_CHOICE)));
                    registrations.add(registration);
                } while (cursor.moveToNext());
            }

            // close db connection
            db.close();

            // return notes list
            return registrations;
        }
        public int getRegistrationCount() {
            String countQuery = "SELECT  * FROM " + Registration.TABLE_NAME;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(countQuery, null);

            int count = cursor.getCount();
            cursor.close();

            // return count
            return count;
        }
        public int updateRegistrationTable(Registration registration) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Registration.COLUMN_PHONE, registration.getPhone());
            values.put(Registration.COLUMN_DSLAM, registration.getDslam());
            values.put(Registration.COLUMN_CHOICE,registration.getChoice());

            // updating row
            return db.update(Registration.TABLE_NAME, values, Registration.COLUMN_PHONE + " = ?",
                    new String[]{registration.getPhone()});
        }
        public void deleteRegistrationEntry(Registration registration) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(Registration.TABLE_NAME, Registration.COLUMN_PHONE + " = ?",
                    new String[]{registration.getPhone()});
            db.close();
        }

    }