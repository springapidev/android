package com.coderbd.ex07_intentdatatransfer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rajail Islam on 9/30/2017.
 */

public class PersonAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<Person> personList;

    public PersonAdapter(Context mContext, ArrayList<Person> personList) {
        this.mContext = mContext;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int i) {
        return personList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(mContext, R.layout.layout_list, null);
        TextView name=(TextView)v.findViewById(R.id.person_name);
        TextView age=(TextView)v.findViewById(R.id.person_age);
        // set Text
        name.setText(personList.get(i).getName());
        age.setText(personList.get(i).getAge());
        return v;
    }
}
