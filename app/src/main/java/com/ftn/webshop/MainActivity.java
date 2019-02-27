package com.ftn.webshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ftn.webshop.databaseHelper.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        myDb.getWritableDatabase();
    }
}
