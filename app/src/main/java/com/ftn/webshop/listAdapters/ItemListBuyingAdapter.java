package com.ftn.webshop.listAdapters;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ftn.webshop.R;
import com.ftn.webshop.models.Item;

import java.util.List;

public class ItemListBuyingAdapter extends BaseAdapter {

    Activity context;
    List<Item> items;
    private static LayoutInflater inflater =null;

    public ItemListBuyingAdapter(Activity context, List<Item> items){
        this.context = context;
        this.items = items;
        this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView=(itemView == null) ? inflater.inflate(R.layout.item_list_buying_view,null): itemView;

        TextView name = (TextView) itemView.findViewById(R.id.itemName);
        TextView price = (TextView) itemView.findViewById(R.id.itemPrice);
        ImageView image = (ImageView) itemView.findViewById(R.id.imageView);
        final Button add = itemView.findViewById(R.id.plusBtn);
        final TextView itemCount = (TextView) itemView.findViewById(R.id.itemCount);
        itemCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!itemCount.getText().toString().equals("")){
                    int itemCounter = Integer.parseInt(itemCount.getText().toString());
                    if(itemCounter > 99)
                        itemCount.setText("99");
                }else{
                    itemCount.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        add.setFocusable(false);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(itemCount.getText().toString()) + 1;
                if(count > 99)
                    count = 99;
                itemCount.setText(Integer.toString(count));
            }
        });
        final Button remove = itemView.findViewById(R.id.minusBtn);
        remove.setFocusable(false);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(itemCount.getText().toString()) - 1;
                if(count < 0)
                    count = 0;
                itemCount.setText(Integer.toString(count));
            }
        });
        Item selectedItem = items.get(position);
        name.setText(selectedItem.getName());
        String priceString = Long.toString(selectedItem.getPrice());
        price.setText(priceString);
        String imageLocation = selectedItem.getImageLocation();

        int drawableID = context.getResources().getIdentifier(imageLocation, "drawable", context.getPackageName());

        image.setImageResource(drawableID);


        return itemView;
    }
}
