package com.ftn.webshop.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ftn.webshop.Activity.AdminScreen;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.listAdapters.ManagerListAdapter;
import com.ftn.webshop.models.User;

import java.util.List;

public class AddShopDialog  extends AppCompatDialogFragment {

    private EditText shopName;
    private EditText shopLocation;
    private EditText shopDescription;
    private EditText imageLocation;
    private Spinner shopSpinner;
    private String managerEmail;
    DatabaseHelper db;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.shop_dialog,null);

        db = new DatabaseHelper(getContext());
        List<User> managers=db.getAllManagers();

        builder.setView(view);
        builder.setTitle("Add Shop");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String name = shopName.getText().toString();
                String location = shopLocation.getText().toString();
                String description = shopDescription.getText().toString();
                String imgLocation= imageLocation.getText().toString();
                DatabaseHelper db = new DatabaseHelper(getContext());

                if (name.equals("") || location.equals("") ||description.equals("") || managerEmail.equals("")) {
                    Toast.makeText(getContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                } else {
                    Boolean checkShopName = db.checkShopName(name);
                    if(checkShopName){
                        Boolean instertShop = db.insertShop(name,location,description,imgLocation,managerEmail);
                        if (instertShop == true) {
                            Toast.makeText(getContext(), "Shop Added successfully!", Toast.LENGTH_LONG).show();
                            Intent adminIntent = new Intent(getContext(), AdminScreen.class);
                            getActivity().finish();
                            startActivity(adminIntent);

                        }
                    }else {
                        Toast.makeText(getContext(), "Shop name allready taken!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        } );

        shopName = view.findViewById(R.id.shopName);
        shopLocation = view.findViewById(R.id.shopLocation);
        shopDescription = view.findViewById(R.id.shopDescription);
        imageLocation = view.findViewById(R.id.shopImageLocation);
        shopSpinner = (Spinner) view.findViewById(R.id.shopSpinner);

        if(managers!=null){
            ManagerListAdapter adapter = new ManagerListAdapter(getActivity(),managers);
            shopSpinner.setAdapter(adapter);
            shopSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    User u=(User)parent.getItemAtPosition(position);
                    managerEmail=u.getEmail();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        return builder.create();

    }
}
