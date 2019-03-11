package com.ftn.webshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ftn.webshop.Controller.Login;
import com.ftn.webshop.R;
import com.ftn.webshop.models.User;

public class HomeScreen extends AppCompatActivity {

    TextView user;
    Button shopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Intent intent=getIntent();
        User u=(User)intent.getSerializableExtra("user");
        user=findViewById(R.id.usertext);
        user.setText(user.getText()+ " "+ u.getType().toString() + " " + u.getName()+ " " + u.getSurname());

        shopButton = findViewById(R.id.goToShop);
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeScreen.this, GridViewItems.class);
                startActivity(i);
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
                Toast.makeText(getApplicationContext(), "You clicked Settings!", + Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
