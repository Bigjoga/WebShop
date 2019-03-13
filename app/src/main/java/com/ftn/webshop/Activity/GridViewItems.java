package com.ftn.webshop.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.ftn.webshop.R;

public class GridViewItems extends Activity {

    GridView gridView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigation;

    static final String[] numbers = new String[] {
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z",
            "1", "2", "3", "4", "5",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_page);

        gridView = findViewById(R.id.gridView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numbers);

        gridView.setAdapter(adapter);

        initInstances();

    }

    private void initInstances() {

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(GridViewItems.this, drawerLayout, R.string.hello_world, R.string.hello_world);
        drawerLayout.setDrawerListener(drawerToggle);

        navigation = findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.nav_profile:
                        Toast.makeText(getApplicationContext(), "Clicked on Profile!", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_share:
                        Toast.makeText(getApplicationContext(), "Clicked on Share!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(GridViewItems.this, GridViewItems.class);
                        startActivity(i);
                        break;
                }
                return false;
            }
        });

    }

}
