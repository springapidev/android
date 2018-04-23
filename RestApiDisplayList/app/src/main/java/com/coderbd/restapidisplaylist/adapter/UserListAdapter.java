package com.coderbd.restapidisplaylist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.coderbd.restapidisplaylist.entity.User;
import java.util.List;
import com.coderbd.restapidisplaylist.R;
/**
 * Created by user on 4/23/2018.
 */

public class UserListAdapter extends ArrayAdapter<User> {
    private List<User> users;
    Context context;

    public UserListAdapter(Context context,List<User> users) {
        super(context,R.layout.user_layout, users);
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.user_layout, parent,false);
        User user=this.users.get(position);
        TextView fn=(TextView)convertView.findViewById(R.id.view_first_name);
        TextView ln=(TextView)convertView.findViewById(R.id.view_last_name);
        TextView e=(TextView)convertView.findViewById(R.id.view_email);
        fn.setText(user.getFirstName());
        ln.setText(user.getLastName());
        e.setText(user.getEmail());
        return convertView;
    }
}
