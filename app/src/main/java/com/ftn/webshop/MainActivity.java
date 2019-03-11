package com.ftn.webshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ftn.webshop.Controller.Login;
import com.ftn.webshop.databaseHelper.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    //-->Sign up<--
    Button signButton;
    EditText signName, signSurname, signEmail, signPass;
    //-->Sign in<--
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_page);
        db = new DatabaseHelper(this);

        //Sign up
        signName = findViewById(R.id.nameField);
        signSurname = findViewById(R.id.surnameField);
        signEmail = findViewById(R.id.emailLoginField);
        signPass = findViewById(R.id.passwordLoginField);
        signButton = findViewById(R.id.singUpButton);
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signName.getText().toString();
                String surname = signSurname.getText().toString();
                String email = signEmail.getText().toString();
                String password = signPass.getText().toString();

                if (/*name.equals("") || surname.equals("") || */email.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                } else {
                    Boolean checkMail = db.checkMail(email);
                    if(checkMail==true){
                        Boolean insertUser = db.insert(email, password,name,surname,"USER");
                        if (insertUser == true) {
                            Toast.makeText(getApplicationContext(), "Registered successfully!", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Email ready exist!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        //login
        signInButton = findViewById(R.id.loginButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });
    }
}
