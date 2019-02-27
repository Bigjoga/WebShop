package com.ftn.webshop.databaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shop_db";
    /*public static final String TABLE_NAME = "user_table";
    public static final String COL1 = "EMAIL";
    public static final String COL2 = "NAME";
    public static final String COL3 = "SURNAME";
    public static final String COL4 = "PASSWORD";
    public static final String COL5 = "TYPE";*/

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //db.execSQL(" create table " + TABLE_NAME + " (EMAIL INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,PASSWORD TEXT, TYPE TEXT)");
        //sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS shop (_id INTEGER PRIMARY KEY AUTOINCREMENT, pib TEXT, name TEXT, location TEXT, description TEXT) ");
        sqLiteDatabase.execSQL(SampleDBContract.Shop.CREATE_TABLE);
        sqLiteDatabase.execSQL(SampleDBContract.Account.CREATE_TABLE);
        sqLiteDatabase.execSQL(SampleDBContract.Item.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Shop.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Account.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Item.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
