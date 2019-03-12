package com.ftn.webshop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ftn.webshop.Controller.Login;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.dialogs.AddManagerDialog;
import com.ftn.webshop.listAdapters.ItemListAdapter;
import com.ftn.webshop.listAdapters.ShopListAdapter;
import com.ftn.webshop.models.Item;
import com.ftn.webshop.models.Shop;
import com.ftn.webshop.models.User;

import java.util.List;

public class ManagerShopView extends AppCompatActivity {

    DatabaseHelper db;
    ListView itemListView;
    Button addItemBtn;
    TextView title;
    Shop s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_shop_view);
        Intent intent=getIntent();
        s = (Shop) intent.getSerializableExtra("shop");

        db = new DatabaseHelper(this );
        itemListView = findViewById(R.id.itemList);
        List<Item> items = db.getAllItemsFromShop(s.getId());

        if(items!=null){
            ItemListAdapter adapter = new ItemListAdapter(this,items);
            itemListView.setAdapter(adapter);
        }
        title = findViewById(R.id.title);
        title.setText(s.getName());

        addItemBtn = findViewById(R.id.addItemBtn);
        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openItemDialog();
            }
        });

    }

    public void openItemDialog(){
        AddItemDialog itemDialog= new AddItemDialog();
        itemDialog.setShopId(s.getId());
        itemDialog.show(getSupportFragmentManager(),"item dialog");
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
                Intent i = new Intent(ManagerShopView.this, Login.class);
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
