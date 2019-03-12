package com.ftn.webshop.listAdapters;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ftn.webshop.R;
import com.ftn.webshop.models.Shop;

import java.io.File;
import java.util.List;

public class ShopListAdapter extends BaseAdapter {
    Activity context;
    List<Shop> shops;
    private static LayoutInflater inflater =null;

    public ShopListAdapter(Activity context, List<Shop> shops){
        this.context = context;
        this.shops = shops;
        this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public Object getItem(int position) {
        return shops.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View itemView=convertView;
        itemView=(itemView == null) ? inflater.inflate(R.layout.shop_list_view,null): itemView;
        TextView name = (TextView) itemView.findViewById(R.id.shopName);
        TextView description = (TextView) itemView.findViewById(R.id.shopDescription);
        TextView location = (TextView) itemView.findViewById(R.id.shopLocation);
        ImageView image= (ImageView) itemView.findViewById(R.id.imageView);
        Shop selectedShop = shops.get(position);

        name.setText(selectedShop.getName());
        description.setText(selectedShop.getDescription());
        location.setText(selectedShop.getLocation());
        String imageLocation=selectedShop.getImageLocation();

        

        int drawableID = context.getResources().getIdentifier(imageLocation, "drawable", context.getPackageName());
        image.setImageResource(drawableID);
    

        return itemView;
    }
}
