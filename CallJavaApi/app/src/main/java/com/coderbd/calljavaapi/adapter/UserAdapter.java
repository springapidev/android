package com.coderbd.calljavaapi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.coderbd.calljavaapi.R;
import com.coderbd.calljavaapi.entity.User;

import java.util.List;

/**
 * Created by Rajaul Islam on 4/22/2018.
 */

public class UserAdapter extends ArrayAdapter<User> {

    private List<User> users;
    Context context;

    public UserAdapter(List<User> users, Context context) {
        super(context, R.layout.user_layout, users);
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.user_layout, parent,false);
        User user=this.users.get(position);
        TextView fname=(TextView)convertView.findViewById(R.id.first_name);
        fname.setText(user.getFirstName());
        TextView lname=(TextView)convertView.findViewById(R.id.last_name);
        lname.setText(user.getLastName());
        TextView email=(TextView)convertView.findViewById(R.id.email);
        email.setText(user.getEmail());
        return convertView;
    }
}
