package com.ftn.webshop.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ftn.webshop.Controller.Login;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.listAdapters.ItemListBuyingAdapter;
import com.ftn.webshop.listAdapters.ShopSpinnerAdapter;
import com.ftn.webshop.models.Item;
import com.ftn.webshop.models.Shop;
import com.ftn.webshop.models.User;

import java.io.Serializable;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    DatabaseHelper db;
    ListView itemListView;
    Spinner shopSpinner;
    TextView searchFilter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigation;
    Activity c;
    User user;

    View background_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        c = this;
        db = new DatabaseHelper(this );
        searchFilter = findViewById(R.id.searchFilter);
        itemListView = findViewById(R.id.gridItemList);
        shopSpinner = findViewById(R.id.shopSpinner);

        List<Shop> shops = db.getAllShops();
        if(shops != null){
            Shop s = new Shop();
            s.setName("All");
            shops.add(0,s);
            ShopSpinnerAdapter adapter = new ShopSpinnerAdapter(this,shops);
            shopSpinner.setAdapter(adapter);
            shopSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    List<Item> items = db.getFilteredItems(searchFilter.getText().toString(),(Shop)shopSpinner.getSelectedItem());
                    if(items != null){
                        ItemListBuyingAdapter adapter = new ItemListBuyingAdapter(c,items);
                        itemListView.setAdapter(adapter);
                    }


                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });
        }

        final Intent intent = getIntent();
        user = (User)intent.getSerializableExtra("user");

        List<Item> items = db.getAllItems();
        if(items != null){
            ItemListBuyingAdapter adapter = new ItemListBuyingAdapter(this,items);
            itemListView.setAdapter(adapter);
        }
        searchFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<Item> items = db.getFilteredItems(searchFilter.getText().toString(),(Shop)shopSpinner.getSelectedItem());
                if(items != null){
                    ItemListBuyingAdapter adapter = new ItemListBuyingAdapter(c,items);
                    itemListView.setAdapter(adapter);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        initInstances();
    }

    private void initInstances() {

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(HomeScreen.this, drawerLayout, R.string.hello_world, R.string.hello_world);
        drawerLayout.setDrawerListener(drawerToggle);

        navigation = findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                Intent i;
                switch (id) {
                    case R.id.nav_home:
                        i = getIntent();
                        i.setClass(HomeScreen.this, HomeScreen.class);
                        startActivity(i);
                        break;
                    case R.id.nav_profile:
                        i = getIntent();
                        i.setClass(HomeScreen.this, ProfileScreen.class);
                        startActivityForResult(i,1);
                        break;

                }
                return false;
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
                Intent i = new Intent(HomeScreen.this, Login.class);
                Toast.makeText(getApplicationContext(), "Logging out", + Toast.LENGTH_LONG).show();
                finish();
                startActivity(i);
                break;
            case R.id.menuSettings:
                Intent in = new Intent(HomeScreen.this, DayNightSwitch.class);
                Toast.makeText(getApplicationContext(), "You clicked Settings!", + Toast.LENGTH_LONG).show();
                startActivity(in);
                break;
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                user = (User) data.getSerializableExtra("user");
                Intent i = getIntent();
                i.putExtra("user", (Serializable) user);
            }
        }
    }
}
