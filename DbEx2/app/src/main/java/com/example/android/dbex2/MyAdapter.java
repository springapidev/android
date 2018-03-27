package com.example.android.dbex2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rajail Islam on 11/1/2017.
 */

public class MyAdapter extends BaseAdapter {
    private final Context context;
    private List<Contact> contactList;
LayoutInflater inflater;
    public MyAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;

    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(context, R.layout.list, null);
       // TextView ids=(TextView)v.findViewById(R.id.view_id);
        TextView name=(TextView)v.findViewById(R.id.view_name);
        TextView mobile=(TextView)v.findViewById(R.id.view_mobile);
        TextView email=(TextView)v.findViewById(R.id.view_email);
        // set Text
       // ids.setText(contactList.get(i).getID());
        name.setText(contactList.get(i).getName());
        mobile.setText(contactList.get(i).getPhoneNumber());
        email.setText(contactList.get(i).getEmail());
        return v;
    }
}
