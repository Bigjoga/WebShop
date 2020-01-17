package com.ftn.webshop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ftn.webshop.Controller.Login;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.listAdapters.ManagerListAdapter;
import com.ftn.webshop.listAdapters.ShopListAdapter;
import com.ftn.webshop.models.Shop;
import com.ftn.webshop.models.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ManagerScreen extends AppCompatActivity {

    DatabaseHelper db;
    ListView shopsListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_screen);

        Intent intent=getIntent();
        User u=(User)intent.getSerializableExtra("user");
        db = new DatabaseHelper(this);
        List<Shop> shops = db.getAllManagedShops(u.getEmail());
        shopsListView = (ListView) findViewById(R.id.shopList);
        if(shops!=null){
            ShopListAdapter adapter = new ShopListAdapter(this,shops);
            shopsListView.setAdapter(adapter);
        }
        shopsListView = findViewById(R.id.shopList);
        shopsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent shopIntent = new Intent(view.getContext(),ManagerShopView.class);
                Shop obj = (Shop) parent.getItemAtPosition(position);
                Shop shop=db.getshopByName(obj.getName());

                shopIntent.putExtra("shop", (Serializable) shop);
                startActivity(shopIntent);


                //Toast.makeText(view.getContext(), "Shop :" + parent.getItemAtPosition(position),Toast.LENGTH_LONG).show();

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
                Intent i = new Intent(ManagerScreen.this, Login.class);
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
}
