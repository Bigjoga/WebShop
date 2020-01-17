package com.ftn.webshop.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ftn.webshop.Controller.Login;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.models.Shop;
import com.ftn.webshop.models.User;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailItemView extends FragmentActivity implements OnMapReadyCallback {

    DatabaseHelper db;
    ListView itemListView;
    TextView searchFilter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigation;
    Activity c;
    User user;
    Shop shop;
    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_view);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent=getIntent();
        User u=(User)intent.getSerializableExtra("user");

        initInstances();
    }

    private void initInstances() {

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(DetailItemView.this, drawerLayout, R.string.hello_world, R.string.hello_world);
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
                        i.setClass(DetailItemView.this, HomeScreen.class);
                        startActivity(i);
                        break;
                    case R.id.nav_profile:
                        i = getIntent();
                        i.setClass(DetailItemView.this, ProfileScreen.class);
                        startActivityForResult(i,1);
                        break;

                }
                return false;
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng noviSad = new LatLng(45.249289, 19.837330);

        float zoomLevel = 15.0f; //This goes up to 21
        mMap.addMarker(new MarkerOptions().position(noviSad).title("WinWin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(noviSad, zoomLevel));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuLogout:
                Intent i = new Intent(DetailItemView.this, Login.class);
                Toast.makeText(getApplicationContext(), "Logging out", + Toast.LENGTH_LONG).show();
                finish();
                startActivity(i);
                break;
            case R.id.menuSettings:
                Intent in = new Intent(DetailItemView.this, DayNightSwitch.class);
                Toast.makeText(getApplicationContext(), "You clicked Settings!", + Toast.LENGTH_LONG).show();
                startActivity(in);
                break;
        }
        return true;
    }

}
