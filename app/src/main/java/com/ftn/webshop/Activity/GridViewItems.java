package com.ftn.webshop.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ftn.webshop.R;
import com.ftn.webshop.models.Item;

import java.util.List;


public class GridViewItems extends RecyclerView.Adapter<GridViewItems.ViewHolder> {

    private Context mContext;
    private List<Item> mData;

    public GridViewItems(Context mContext, List<Item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.shop_page);
        

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView){
            super(itemView);
        }
    }

}
