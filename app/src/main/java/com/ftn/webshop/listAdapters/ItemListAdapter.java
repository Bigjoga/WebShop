package com.ftn.webshop.listAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ftn.webshop.R;
import com.ftn.webshop.models.Item;
import com.ftn.webshop.models.Shop;

import java.util.List;

public class ItemListAdapter extends BaseAdapter {

    Activity context;
    List<Item> items;
    private static LayoutInflater inflater =null;

    public ItemListAdapter(Activity context, List<Item> items){
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
        itemView=(itemView == null) ? inflater.inflate(R.layout.item_list_view,null): itemView;
        TextView name = (TextView) itemView.findViewById(R.id.itemName);
        TextView description = (TextView) itemView.findViewById(R.id.itemDescription);
        TextView price = (TextView) itemView.findViewById(R.id.itemPrice);
        ImageView image= (ImageView) itemView.findViewById(R.id.imageView);
        Item selectedItem = items.get(position);

        name.setText(selectedItem.getName());
        description.setText(selectedItem.getDescription());
        String priceString=Long.toString(selectedItem.getPrice());
        price.setText(priceString);
        String imageLocation = selectedItem.getImageLocation();

        int drawableID = context.getResources().getIdentifier(imageLocation, "drawable", context.getPackageName());

        image.setImageResource(drawableID);


        return itemView;
    }
}
