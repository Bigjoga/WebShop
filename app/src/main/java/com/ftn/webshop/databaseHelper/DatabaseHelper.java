package com.ftn.webshop.databaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "WebShop.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SampleDBContract.User.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        /*sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Shop.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Account.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Item.TABLE_NAME);*/
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.User.TABLE_NAME);

        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
    }

    //addUser
    public boolean insert(String email, String password,String name,String surname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SampleDBContract.User.COLUMN_ACCOUNT_EMAIL,email);
        cv.put(SampleDBContract.User.COLUMN_ACCOUNT_PASSWORD,password);
        cv.put(SampleDBContract.User.COLUMN_USER_NAME,name);
        cv.put(SampleDBContract.User.COLUMN_USER_SURNAME,surname);
        //cv.put("email",email);
        //cv.put("password", password);
        long ins = db.insert(SampleDBContract.User.TABLE_NAME,null,cv);
        //long ins = db.insert("user",null,cv);

        if(ins == -1) return false;
        else return true;
    }

    //check does mail exist
    public Boolean checkMail(String mail){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email=?", new String[]{mail});
        if(cursor.getCount()>0){
            return false;
        }else return true;
    }

    //check mail and pass for login
    public Boolean emailAndPassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email=? AND password=?", new String[]{email,password});
        if(cursor.getCount()>0){
            return false;
        }else return true;
    }
}
