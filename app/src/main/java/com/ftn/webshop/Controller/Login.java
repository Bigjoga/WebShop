package com.ftn.webshop.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;

public class Login extends AppCompatActivity {

    EditText signInEmail,signInPass;
    Button signInButton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        db = new DatabaseHelper(this);
        signInEmail = (EditText)findViewById(R.id.emailLoginField);
        signInPass = (EditText)findViewById(R.id.passwordLoginField);
        signInButton = (Button)findViewById(R.id.loginButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signInEmail.getText().toString();
                String pass = signInPass.getText().toString();
                Boolean checkMailAndPassword = db.emailAndPassword(email,pass);
                if(checkMailAndPassword == true){
                    Toast.makeText(getApplicationContext(), "Successfully login!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong email or password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
