package com.ftn.webshop.databaseHelper;

import android.provider.BaseColumns;

public final class SampleDBContract {

    private SampleDBContract() {
    }

    //shop
    public static class Shop implements BaseColumns{
        public static final String TABLE_NAME = "shop";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_LOCATION = "location";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_LOCATION + " TEXT NOT NULL, " +
                COLUMN_DESCRIPTION + " TEXT " + ")";
    }

    //user

    public static class User implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_ACCOUNT_EMAIL = "email";
        public static final String COLUMN_ACCOUNT_PASSWORD = "password";
        public static final String COLUMN_USER_NAME = "name";
        public static final String COLUMN_USER_SURNAME = "surname";
        public static final String COLUMN_USER_TYPE = "type";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                COLUMN_ACCOUNT_EMAIL + " TEXT PRIMARY KEY NOT NULL, " +
                COLUMN_ACCOUNT_PASSWORD + " TEXT NOT NULL, " +
                COLUMN_USER_NAME + " TEXT NOT NULL," +
                COLUMN_USER_SURNAME + " TEXT NOT NULL," +
                COLUMN_USER_TYPE + " TEXT NOT NULL" + ")";
    }

    //account
    public static class Account implements BaseColumns{
        public static final String TABLE_NAME = "account";
        public static final String COLUMN_ACCOUNT_ID = "accountId";
        public static final String COLUMN_ACCOUNT_NUMBER = "accountNumber";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ACCOUNT_ID + " TEXT NOT NULL, " +
                COLUMN_ACCOUNT_NUMBER + " TEXT NOT NULL, " + ")";
    }

    //item
    public static class Item implements BaseColumns{
        public static final String TABLE_NAME = "item";
        public static final String COLUMN_NUMBER_ID = "idNumber";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NUMBER_ID + " TEXT NOT NULL, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_DESCRIPTION + " TEXT NOT NULL, " + ")";
    }

}
