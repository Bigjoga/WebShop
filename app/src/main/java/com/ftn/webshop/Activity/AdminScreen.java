package com.ftn.webshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.ftn.webshop.Controller.Login;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.dialogs.AddManagerDialog;
import com.ftn.webshop.listAdapters.ManagerListAdapter;
import com.ftn.webshop.models.User;

import java.util.List;

import javax.net.ssl.ManagerFactoryParameters;

public class AdminScreen extends AppCompatActivity {

    DatabaseHelper db;
    ListView listView;
    Button addManagerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);

        Intent intent=getIntent();
        User u=(User)intent.getSerializableExtra("user");

        db = new DatabaseHelper(this);
        List<User> managers=db.getAllManagers();

        listView = (ListView) findViewById(R.id.managerList);
        ManagerListAdapter adapter = new ManagerListAdapter(this,managers);
        listView.setAdapter(adapter);

        listView = findViewById(R.id.managerList);
        addManagerBtn = findViewById(R.id.addManagerBtn);
        addManagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManagerDialog();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuLogout:
                Intent i = new Intent(AdminScreen.this, Login.class);
                Toast.makeText(getApplicationContext(), "Logging out", + Toast.LENGTH_LONG).show();
                finish();
                startActivity(i);
                break;
            case R.id.menuSettings:
                Toast.makeText(getApplicationContext(), "You clicked Settings!", + Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    public void openManagerDialog(){
        AddManagerDialog managerDialog= new AddManagerDialog();
        managerDialog.show(getSupportFragmentManager(),"manager dialog");


    }

}
