package com.coderbd.easysilence;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DailySilent extends AppCompatActivity {
EditText fjrStart, fjrEnd;
CheckBox fjrCheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_silent);
        fjrStart=(EditText)findViewById(R.id.fajr_time_start);
        fjrEnd=(EditText)findViewById(R.id.fajr_time_end);
        fjrCheckbox=(CheckBox) findViewById(R.id.fajr_time_checkbox);

        fjrStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(DailySilent.this, new TimePickerDialog.OnTimeSetListener() {
                   @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                       fjrStart.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

        fjrEnd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(DailySilent.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        fjrEnd.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

        fjrCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
           public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                String st=fjrStart.getText().toString();
                fjrStart.setText(st);
                String et=fjrEnd.getText().toString();
                fjrEnd.setText(et);
                System.out.println("Starting Time: "+st+" Ending Time: "+et);
                Toast.makeText(getApplicationContext(),"Starting Time: "+st+" Ending Time: "+et,Toast.LENGTH_SHORT).show();

              }
            }
        );

    }
}
