package com.ftn.webshop.Activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ftn.webshop.Controller.Login;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.models.User;

import java.io.Serializable;

public class ProfileScreen extends AppCompatActivity {

    User user;
    TextView nameField,surnameField,emailField,passwordField;
    ImageView image;
    Button changeBtn;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigation;
    DatabaseHelper  db = new DatabaseHelper(this );
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__screen);

        final Intent intent = getIntent();
        user = (User)intent.getSerializableExtra("user");
        i = getIntent();

        nameField = findViewById(R.id.nameField);
        surnameField = findViewById(R.id.surnameField);
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        image = findViewById(R.id.imageView);
        changeBtn = findViewById(R.id.changeBtn);


        nameField.setText(user.getName());
        surnameField.setText(user.getSurname());
        emailField.setText(user.getEmail());
        passwordField.setText(user.getPassword());
        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = db.changeInfo(user,nameField.getText().toString(),surnameField.getText().toString(),emailField.getText().toString(),passwordField.getText().toString());
                i.putExtra("user", (Serializable) user);
            }
        });

        initInstances();
    }

    private void initInstances() {

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(ProfileScreen.this, drawerLayout, R.string.hello_world, R.string.hello_world);
        drawerLayout.setDrawerListener(drawerToggle);

        navigation = findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.nav_home:
                        i = getIntent();
                        i.setClass(ProfileScreen.this, HomeScreen.class);
                        startActivity(i);
                        break;
                    case R.id.nav_profile:
                        i = getIntent();
                        i.setClass(ProfileScreen.this, ProfileScreen.class);
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
                Intent i = new Intent(ProfileScreen.this, Login.class);
                Toast.makeText(getApplicationContext(), "Logging out", + Toast.LENGTH_LONG).show();
                finish();
                startActivity(i);
                break;
            case R.id.menuSettings:
                Intent in = new Intent(ProfileScreen.this, DayNightSwitch.class);
                Toast.makeText(getApplicationContext(), "You clicked Settings!", + Toast.LENGTH_LONG).show();
                startActivity(in);
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        i.putExtra("user", (Serializable) user);
        setResult(RESULT_OK, i);
        finish();
    }
}
