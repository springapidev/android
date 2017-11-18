package com.coderbd.easysilentpro;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Rajaul Islam on 11/2/2017.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    List<EasySchedule> easyScheduleList;

    public CustomAdapter(Context context, List<EasySchedule> easyScheduleList) {
        this.context = context;
        this.easyScheduleList = easyScheduleList;
    }

    @Override
    public int getCount() {
        return easyScheduleList.size();
    }

    @Override
    public Object getItem(int i) {
        return easyScheduleList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.list, null);
        TextView sName = (TextView) v.findViewById(R.id.view_name);
        TextView sTime = (TextView) v.findViewById(R.id.view_starting_time);
        TextView eTime = (TextView) v.findViewById(R.id.view_ending_time);
        CheckBox status = (CheckBox) v.findViewById(R.id.view_status);
        // set Text
        sName.setText(easyScheduleList.get(i).getName());
        sTime.setText(easyScheduleList.get(i).getStartingTime());
        eTime.setText(easyScheduleList.get(i).getEndingTime());
        String sts = easyScheduleList.get(i).getStatus();
        if (sts.contains("1")) {
            status.setChecked(true);
        } else {
            status.setChecked(false);
        }
        return v;
    }
}
