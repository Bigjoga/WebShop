package com.ftn.webshop.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ftn.webshop.Activity.AdminScreen;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;

import java.io.Serializable;

public class AddManagerDialog extends AppCompatDialogFragment {

    private EditText managerName;
    private EditText managerSurname;
    private EditText managerEmail;
    private EditText managerPassword;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.manager_dialog,null);

        managerName = view.findViewById(R.id.managerName);
        managerSurname = view.findViewById(R.id.managerSurname);
        managerEmail = view.findViewById(R.id.managerEmail);
        managerPassword = view.findViewById(R.id.managerPassword);

        builder.setView(view);
        builder.setTitle("Add Manager");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



                String name = managerName.getText().toString();
                String surname = managerSurname.getText().toString();
                String email = managerEmail.getText().toString();
                String password = managerPassword.getText().toString();
                DatabaseHelper db = new DatabaseHelper(getContext());

                if (name.equals("") || surname.equals("") ||email.equals("") || password.equals("")) {
                    Toast.makeText(getContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                } else {
                    Boolean checkMail = db.checkMail(email);
                    if(checkMail==true){
                        Boolean insertUser = db.insert(email, password,name,surname,"MANAGER");
                        if (insertUser == true) {
                            Toast.makeText(getContext(), "Manager Added successfully!", Toast.LENGTH_LONG).show();
                            Intent adminIntent = new Intent(getContext(), AdminScreen.class);
                            getActivity().finish();
                            startActivity(adminIntent);

                        }
                    }else {
                        Toast.makeText(getContext(), "Email already exist!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        return builder.create();
    }
}
