package com.ftn.webshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ftn.webshop.Controller.Login;
import com.ftn.webshop.R;
import com.ftn.webshop.databaseHelper.DatabaseHelper;
import com.ftn.webshop.listAdapters.ItemListAdapter;
import com.ftn.webshop.listAdapters.ShopListAdapter;
import com.ftn.webshop.models.Item;
import com.ftn.webshop.models.Shop;
import com.ftn.webshop.models.User;

import java.io.Serializable;
import java.util.List;

public class GridViewItems extends AppCompatActivity {

    DatabaseHelper db;
    ListView itemListView;
    TextView titleItem;
    Shop s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_items);
        Intent intent=getIntent();
        s = (Shop) intent.getSerializableExtra("shop");

        db = new DatabaseHelper(this );
        itemListView = findViewById(R.id.gridItemList);
        List<Item> items = db.getAllItems();

        if(items!=null){
            ItemListAdapter adapter = new ItemListAdapter(this,items);
            itemListView.setAdapter(adapter);
        }
        titleItem = findViewById(R.id.gridItemTitle);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuLogout:
                Intent i = new Intent(GridViewItems.this, Login.class);
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
