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
        //db.execSQL(" create table " + TABLE_NAME + " (EMAIL INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,PASSWORD TEXT, TYPE TEXT)");
        //sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS shop (_id INTEGER PRIMARY KEY AUTOINCREMENT, pib TEXT, name TEXT, location TEXT, description TEXT) ");
        /*sqLiteDatabase.execSQL(SampleDBContract.Shop.CREATE_TABLE);
        sqLiteDatabase.execSQL(SampleDBContract.Account.CREATE_TABLE);
        sqLiteDatabase.execSQL(SampleDBContract.User.CREATE_TABLE);
        sqLiteDatabase.execSQL(SampleDBContract.Item.CREATE_TABLE);*/
        //sqLiteDatabase.execSQL("CREATE TABLE user(email text PRIMARY KEY, password text)");

        sqLiteDatabase.execSQL("CREATE TABLE " + SampleDBContract.User.TABLE_NAME + "( " + SampleDBContract.User.COLUMN_ACCOUNT_EMAIL +
                " TEXT PRIMARY KEY, " + SampleDBContract.User.COLUMN_ACCOUNT_PASSWORD + " TEXT)");

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
    public boolean insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SampleDBContract.User.COLUMN_ACCOUNT_EMAIL,email);
        cv.put(SampleDBContract.User.COLUMN_ACCOUNT_PASSWORD,password);
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
