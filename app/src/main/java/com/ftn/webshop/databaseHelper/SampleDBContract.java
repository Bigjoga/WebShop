package com.ftn.webshop.databaseHelper;

import android.provider.BaseColumns;

public final class SampleDBContract {

    private SampleDBContract() {
    }

    //shop
    public static class Shop implements BaseColumns{
        public static final String TABLE_NAME = "shop";
        public static final String COLUMN_PIB = "pib";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_LOCATION = "location";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PIB + " TEXT NOT NULL, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_LOCATION + " TEXT NOT NULL, " +
                COLUMN_DESCRIPTION + " TEXT " + ")";
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

    //user
}
