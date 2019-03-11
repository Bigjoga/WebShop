package com.ftn.webshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ftn.webshop.R;
import com.ftn.webshop.models.User;

public class HomeScreen extends AppCompatActivity {

    TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Intent intent=getIntent();
        User u=(User)intent.getSerializableExtra("user");
        user=findViewById(R.id.usertext);
        user.setText(user.getText()+ " "+ u.getType().toString() + " " + u.getName()+ " " + u.getSurname());

    }
}
