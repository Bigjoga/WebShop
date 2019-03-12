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
import com.ftn.webshop.dialogs.AddShopDialog;
import com.ftn.webshop.listAdapters.ManagerListAdapter;
import com.ftn.webshop.listAdapters.ShopListAdapter;
import com.ftn.webshop.models.Shop;
import com.ftn.webshop.models.User;

import java.util.List;

import javax.net.ssl.ManagerFactoryParameters;

public class AdminScreen extends AppCompatActivity {

    DatabaseHelper db;
    ListView manageresListView;
    ListView shopsListView;
    Button addManagerBtn;
    Button addShopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);

        Intent intent=getIntent();
        User u=(User)intent.getSerializableExtra("user");

        db = new DatabaseHelper(this);
        List<User> managers=db.getAllManagers();
        manageresListView = (ListView) findViewById(R.id.managerList);
        if(managers!=null){
            ManagerListAdapter adapter = new ManagerListAdapter(this,managers);
            manageresListView.setAdapter(adapter);
        }
        List<Shop> shops=db.getAllShops();
        shopsListView = (ListView) findViewById(R.id.shopList);
        if(shops!=null){
            ShopListAdapter adapter = new ShopListAdapter(this,shops);
            shopsListView.setAdapter(adapter);
        }



        manageresListView = findViewById(R.id.managerList);
        shopsListView = findViewById(R.id.shopList);
        addManagerBtn = findViewById(R.id.addManagerBtn);
        addManagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManagerDialog();
            }
        });
        addShopBtn = findViewById(R.id.addShopBtn);
        addShopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSHopDialog();
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

    public void openSHopDialog(){
        AddShopDialog shopDialog= new AddShopDialog();
        shopDialog.show(getSupportFragmentManager(),"shop dialog");


    }

}
