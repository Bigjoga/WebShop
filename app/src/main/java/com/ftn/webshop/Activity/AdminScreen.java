package com.ftn.webshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.models.User;

import java.util.List;

public class AdminScreen extends AppCompatActivity {

    DatabaseHelper db;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);

        Intent intent=getIntent();
        User u=(User)intent.getSerializableExtra("user");

        db = new DatabaseHelper(this);
        List<User> managers=db.getAllManagers();
        Log.i(managers.toString(),managers.toString());
        tableLayout = findViewById(R.id.managerTable);
        for(User user:managers){
            TableRow tr=new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            TextView email = new TextView(this);
            email.setText(user.getEmail());
            email.setTextSize(18);
            email.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tr.addView(email);
            TextView name = new TextView(this);
            name.setText(user.getName());
            name.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            name.setTextSize(18);
            tr.addView(name);
            TextView surname = new TextView(this);
            surname.setText(user.getSurname());
            surname.setTextSize(18);
            surname.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tr.addView(surname);
            tableLayout.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));

        }






    }
}
