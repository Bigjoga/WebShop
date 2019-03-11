package com.ftn.webshop.listAdapters;

import android.app.Activity;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ftn.webshop.R;
import com.ftn.webshop.models.User;


import java.util.List;

public class ManagerListAdapter extends BaseAdapter {

    Activity context;
    List<User> users;
    private static LayoutInflater inflater =null;

    public ManagerListAdapter(Activity context, List<User> users){
        this.context = context;
        this.users=users;
        this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView=convertView;
        itemView=(itemView == null) ? inflater.inflate(R.layout.manager_list_view,null): itemView;
        TextView nameColumn = (TextView) itemView.findViewById(R.id.nameColumn);
        TextView surnameColumn = (TextView) itemView.findViewById(R.id.surnameColumn);
        TextView emailColumn = (TextView) itemView.findViewById(R.id.emailColumn);
        User selectedUser = users.get(position);

        nameColumn.setText(selectedUser.getName());
        surnameColumn.setText(selectedUser.getSurname());
        emailColumn.setText(selectedUser.getEmail());
        return itemView;
    }
}
