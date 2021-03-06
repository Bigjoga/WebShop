package com.ftn.webshop.databaseHelper;

import android.provider.BaseColumns;
import android.util.Base64;
import android.widget.BaseAdapter;

import com.ftn.webshop.models.Item;

import org.json.JSONObject;

import java.util.HashMap;

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
        public static final String COLUMN_IMAGE_LOCATION = "imageLocation";
        public static final String COLUMN_MANAGER_EMAIL = "managerEmail";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_LOCATION + " TEXT NOT NULL, " +
                COLUMN_DESCRIPTION + " TEXT NOT NULL," +
                COLUMN_IMAGE_LOCATION + " TEXT NOT NULL," +
                COLUMN_MANAGER_EMAIL + " TEXT NOT NULL," +
                "FOREIGN KEY (" + Shop.COLUMN_MANAGER_EMAIL + ") REFERENCES " + User.TABLE_NAME + "( " + User.COLUMN_ACCOUNT_EMAIL + "));";
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
        public static final String COLUMN_ACCOUNT_EMAIL = "accountId";
        public static final String COLUMN_ACCOUNT_NUMBER = "accountNumber";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                COLUMN_ACCOUNT_EMAIL + " TEXT PRIMARY KEY NOT NULL, " +
                COLUMN_ACCOUNT_NUMBER + " TEXT NOT NULL, " +
                "FOREIGN KEY (" + Account.COLUMN_ACCOUNT_EMAIL + ") REFERENCES " + User.TABLE_NAME + "( " + User.COLUMN_ACCOUNT_EMAIL + "));";
    }

    //item
    public static class Item implements BaseColumns{
        public static final String TABLE_NAME = "item";
        public static final String COLUMN_ID= "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_IMAGE_LOCATION = "imageLocation";
        public static final String COLUMN_SHOP_ID= "shop_id";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                COLUMN_PRICE + " INTEGER NOT NULL, " +
                COLUMN_IMAGE_LOCATION + " TEXT NOT NULL, " +
                COLUMN_SHOP_ID + " INTEGER NOT NULL, " +
                "FOREIGN KEY (" + Item.COLUMN_SHOP_ID + ") REFERENCES " + Shop.TABLE_NAME + "( " + Shop.COLUMN_ID + "));";

    }

    public static class ShoppingCart implements BaseColumns{
        private HashMap<Item, Integer> map;
        JSONObject jso = new JSONObject( map );
      //  String encoded = new String(Base64.encodeToString(jso.toString().getBytes());
    }
}
