package com.coderbd.alarmmanger;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {
    Button b1, cancel;
    CheckBox chk;
    private AudioManager myAudioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);

        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               startAlerts();
            }
        });

        cancel=(Button)findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlerts();
            }
        });

        ////////////////////////////////
        chk=(CheckBox)findViewById(R.id.check_box);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub

                if(isChecked)
                {
             startAlerts();

         //  Toast.makeText(MainActivity.this, "Android Checked", Toast.LENGTH_LONG).show();
                }
                else
                {

           cancelAlerts();  // Toast.makeText(MainActivity.this, "Android Un-Checked", Toast.LENGTH_LONG).show();
                }

            }

        });
    }
    /*
    public void startAlert() {
        EditText text = (EditText) findViewById(R.id.time);
        int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();

    }
*/
    PendingIntent pendingIntent;
    public void startAlerts() {
        EditText text = (EditText) findViewById(R.id.time);
        int i = Integer.parseInt(text.getText().toString());
        //Create a new PendingIntent and add it to the AlarmManager
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager am =
                (AlarmManager)getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, (i*1000),
                (50*1000),pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();
          }


    public void cancelAlerts() {
        EditText text = (EditText) findViewById(R.id.time);
        int i = Integer.parseInt(text.getText().toString());
        //Create a new PendingIntent and add it to the AlarmManager
        Intent intent = new Intent(this, MyCancelBroadcastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager am =
                (AlarmManager)getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, (i*1000),
                (50*1000),pendingIntent);
        Toast.makeText(this, "Alarm cancel",Toast.LENGTH_LONG).show();
         }



}