package com.ftn.webshop.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ftn.webshop.Activity.AdminScreen;
import com.ftn.webshop.Activity.HomeScreen;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.models.User;

import java.io.Serializable;

public class Login extends AppCompatActivity {

    EditText signInEmail,signInPass;
    Button signInButton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        db = new DatabaseHelper(this);
        signInEmail = findViewById(R.id.emailLoginField);
        signInPass = findViewById(R.id.passwordLoginField);
        signInButton = findViewById(R.id.loginButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signInEmail.getText().toString();
                String pass = signInPass.getText().toString();
                User user=db.login(email,pass);
                if(user!= null){
                    Toast.makeText(getApplicationContext(), "Successfully login!", Toast.LENGTH_LONG).show();
                    if(user.getType()== User.Type.USER){
                        Intent homeIntent = new Intent(v.getContext(), HomeScreen.class);
                        homeIntent.putExtra("user", (Serializable) user);
                        startActivity(homeIntent);
                    }else if(user.getType()== User.Type.ADMIN){
                        Intent adminIntent = new Intent(v.getContext(), AdminScreen.class);
                        adminIntent.putExtra("user", (Serializable) user);
                        startActivity(adminIntent);
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Wrong email or password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
