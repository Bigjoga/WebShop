package com.ftn.webshop.databaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ftn.webshop.models.Item;
import com.ftn.webshop.models.Shop;
import com.ftn.webshop.models.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "WebShop.db";
    public static int selectedItem = 0;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("RADI","RADI");
        sqLiteDatabase.execSQL(SampleDBContract.User.CREATE_TABLE);
        sqLiteDatabase.execSQL(SampleDBContract.Shop.CREATE_TABLE);
        sqLiteDatabase.execSQL(SampleDBContract.Item.CREATE_TABLE);
        sqLiteDatabase.execSQL(SampleDBContract.Account.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.User.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Item.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Shop.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Account.TABLE_NAME);

    }

    //addUser
    public boolean insert(String email, String password,String name,String surname, String type){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SampleDBContract.User.COLUMN_ACCOUNT_EMAIL,email);
        cv.put(SampleDBContract.User.COLUMN_ACCOUNT_PASSWORD,password);
        cv.put(SampleDBContract.User.COLUMN_USER_NAME,name);
        cv.put(SampleDBContract.User.COLUMN_USER_SURNAME,surname);
        cv.put(SampleDBContract.User.COLUMN_USER_TYPE,type);

        long ins = db.insert(SampleDBContract.User.TABLE_NAME,null,cv);


        if(ins == -1) return false;
        else return true;
    }

    public boolean insertShop(String name, String location,String description,String imageLocation,String managerEmail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SampleDBContract.Shop.COLUMN_NAME,name);
        cv.put(SampleDBContract.Shop.COLUMN_LOCATION,location);
        cv.put(SampleDBContract.Shop.COLUMN_DESCRIPTION,description);
        cv.put(SampleDBContract.Shop.COLUMN_IMAGE_LOCATION,imageLocation);
        cv.put(SampleDBContract.Shop.COLUMN_MANAGER_EMAIL,managerEmail);

        long ins = db.insert(SampleDBContract.Shop.TABLE_NAME,null,cv);


        if(ins == -1) return false;
        else return true;
    }

    public boolean insertItem(String name, String description,int price,String imageLocation,String shop_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SampleDBContract.Item.COLUMN_NAME,name);
        cv.put(SampleDBContract.Item.COLUMN_PRICE,price);
        cv.put(SampleDBContract.Item.COLUMN_DESCRIPTION,description);
        cv.put(SampleDBContract.Item.COLUMN_IMAGE_LOCATION,imageLocation);
        cv.put(SampleDBContract.Item.COLUMN_SHOP_ID,shop_id);

        long ins = db.insert(SampleDBContract.Item.TABLE_NAME,null,cv);


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

    public Boolean checkShopName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM shop WHERE name=?", new String[]{name});
        if(cursor.getCount()>0){
            return false;
        }else return true;
    }

    //check mail and pass for login
    public User login(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email=? AND password=?", new String[]{email,password});
        cursor.moveToPosition(0);

        if(cursor.getCount()>0){
            User u=new User();
            u.getUserFromCursor(cursor);
            return u;
        }else return null;
    }

    public User changeInfo(User u, String name, String surname,String email, String password ){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(SampleDBContract.User.COLUMN_ACCOUNT_EMAIL,email);
        cv.put(SampleDBContract.User.COLUMN_ACCOUNT_PASSWORD,password);
        cv.put(SampleDBContract.User.COLUMN_USER_NAME,name);
        cv.put(SampleDBContract.User.COLUMN_USER_SURNAME,surname);
        db.update("user",cv,SampleDBContract.User.COLUMN_ACCOUNT_EMAIL+"=?",new String[]{u.getEmail()});
        return login(email,password);
    }

    public List<User> getAllManagers(){
        List<User> managers=new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE type=?", new String[]{"MANAGER"});
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            for(int position=0;position<cursor.getCount(); position++){
                User u=new User();
                u.getUserFromCursor(cursor);
                managers.add(u);
                cursor.moveToPosition(position+1);

            }
            return managers;
        }else return null;
    }

    public List<Shop> getAllShops(){
        List<Shop> shops=new ArrayList<Shop>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM shop", null);
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            for(int position=0;position<cursor.getCount(); position++){
                Shop s=new Shop();
                s.getShopFromCursor(cursor);
                shops.add(s);
                cursor.moveToPosition(position+1);

            }
            return shops;
        }else return null;
    }

    public Shop getShopById(Long id) {
        Shop shops;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM shop WHERE id = " + id, null);
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            Shop s=new Shop();
            s.getShopFromCursor(cursor);

            return s;
        }else return null;
    }

    public Item getItemById(Long id) {
        Item item;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM item WHERE id = " + id, null);
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            Item i=new Item();
            i.getShopFromCursor(cursor);

            return i;
        }else return null;
    }


    public List<Shop> getAllManagedShops(String email) {
        List<Shop> shops=new ArrayList<Shop>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM shop WHERE managerEmail=?", new String[]{email});
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            for(int position=0;position<cursor.getCount(); position++){
                Shop s=new Shop();
                s.getShopFromCursor(cursor);
                shops.add(s);
                cursor.moveToPosition(position+1);

            }
            return shops;
        }else return null;
    }

    public Shop getshopByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM shop WHERE name=?", new String[]{name});
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            for(int position=0;position<cursor.getCount(); position++){
                Shop s=new Shop();
                s.getShopFromCursor(cursor);
                return s;
            }
        }
        return null;
    }

    public List<Item> getAllItemsFromShop(Long id) {
        List<Item> items=new ArrayList<Item>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM item WHERE shop_id=?", new String[]{Long.toString(id)});
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            for(int position=0;position<cursor.getCount(); position++){
                Item i=new Item();
                i.getShopFromCursor(cursor);
                items.add(i);
                cursor.moveToPosition(position+1);

            }
            return items;
        }else return null;


    }

    public List<Item> getAllItems() {
        List<Item> items=new ArrayList<Item>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM item", new String[]{});
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            for(int position=0;position<cursor.getCount(); position++){
                Item i=new Item();
                i.getShopFromCursor(cursor);
                items.add(i);
                cursor.moveToPosition(position+1);

            }
            return items;
        }else return null;
    }

    public List<Item> getFilteredItems(String filter, Shop selectedShop) {
        List<Item> items=new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM item", new String[]{});
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            for(int position=0;position<cursor.getCount(); position++){
                Item i=new Item();
                i.getShopFromCursor(cursor);
                if (i.getName().toLowerCase().contains(filter.toLowerCase()) && (selectedShop.getId() == i.getShop_id() || selectedShop.getId() == null)) {
                    items.add(i);
                }
                cursor.moveToPosition(position+1);
            }
            return items;
        }else return null;
    }

    public static int getSelectedItem() {
        return selectedItem;
    }

    public static void setSelectedItem(int i) {
        selectedItem = i;
    }
}
