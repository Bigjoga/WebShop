package com.ftn.webshop.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.ftn.webshop.R;

public class GridViewItems extends Activity {

    GridView gridView;

    static final String[] numbers = new String[] {
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z",
            "1", "2", "3", "4", "5",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
            "P", "Q", "R", "S", "T",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_page);

        gridView = findViewById(R.id.gridView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numbers);

        gridView.setAdapter(adapter);

        /*gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });*/

    }

}
