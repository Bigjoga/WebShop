package com.ftn.webshop.listAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.ftn.webshop.R;
import com.ftn.webshop.models.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopSpinnerAdapter extends ArrayAdapter {
    Context context;
    List<Shop> shops;
    private static LayoutInflater inflater =null;
    public ShopSpinnerAdapter (Context context, List<Shop> shops){
        super(context,0,shops);
        this.context = context;
        this.shops = shops;
        this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        return initView(position,convertView,parent);

    }

    @Override
    public View getDropDownView(int position, View convertView,  ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView(int position,  View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = inflater.inflate(R.layout.shop_spinner_view,parent,false);
        }
        TextView shopName = convertView.findViewById(R.id.shopName);

        Shop currentShop = (Shop) getItem(position);
        if(currentShop != null){
            shopName.setText(currentShop.getName());
        }
        return convertView;
    }


}
