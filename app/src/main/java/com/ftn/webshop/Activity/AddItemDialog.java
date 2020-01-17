package com.ftn.webshop.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.models.Shop;

import java.io.IOException;
import java.io.Serializable;

import static android.app.Activity.RESULT_OK;

public class AddItemDialog extends AppCompatDialogFragment {

    private EditText itemName;
    private EditText itemDescription;
    private EditText itemPrice;
    private EditText itemImageLocation;
    private String itemShop_id;
    private Shop s;
    private Button choose;
    private ImageView image;
    private Bitmap bitmap;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.item_dialog,null);

        Intent intent=getActivity().getIntent();
        s = (Shop) intent.getSerializableExtra("shop");

        choose = (Button) view.findViewById(R.id.choose_image_button);
        image = (ImageView) view.findViewById(R.id.item_image);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 555);
            }
        });

        itemName = view.findViewById(R.id.itemName);
        itemDescription = view.findViewById(R.id.itemDescription);
        itemPrice = view.findViewById(R.id.itemPrice);
        //itemImageLocation = view.findViewById(R.id.itemImageLocation);

        builder.setView(view);
        builder.setTitle("Add Item");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String name = itemName.getText().toString();
                String description = itemDescription.getText().toString();
                int price = Integer.parseInt(itemPrice.getText().toString());
                String imageLocation = itemImageLocation.getText().toString();
                DatabaseHelper db = new DatabaseHelper(getContext());

                if (name.equals("") || description.equals("") ||price < 1 || imageLocation.equals("")) {
                    Toast.makeText(getContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                } else {
                    Boolean insertUser = db.insertItem(name,description,price,imageLocation,itemShop_id);
                    if (insertUser == true) {
                        Toast.makeText(getContext(), "Item Added successfully!", Toast.LENGTH_LONG).show();
                        Intent managerShopView = new Intent(getContext(), ManagerShopView.class);
                        getActivity().finish();
                        managerShopView.putExtra("shop", (Serializable) s);
                        startActivity(managerShopView);
                    }
                    else {
                        Toast.makeText(getContext(), "Item already exist!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        return builder.create();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 555 && resultCode == RESULT_OK && data != null)
        {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), path);
                image.setImageBitmap(bitmap);
                image.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setShopId(Long id) {
        itemShop_id = Long.toString(id);
    }
}
