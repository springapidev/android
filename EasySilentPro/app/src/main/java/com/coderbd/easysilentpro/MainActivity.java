package com.coderbd.easysilentpro;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    final Context context = this;

    EditText names, startTime, endTime;
    CheckBox statuss;
    ListView listviews;
    Button btnAd, btnShowPromt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = (EditText) findViewById(R.id.name);
        startTime = (EditText) findViewById(R.id.start_time);
        endTime = (EditText) findViewById(R.id.end_time);
        statuss = (CheckBox) findViewById(R.id.chk_status);

        listviews = (ListView) findViewById(R.id.listview);
        // btnAd = (Button) findViewById(R.id.btnAdd);
        btnShowPromt = (Button) findViewById(R.id.btn_show_prompt);

//promt dialog start
        // add button listener
        btnShowPromt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.layout_prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                names = (EditText) promptsView.findViewById(R.id.name);
                startTime = (EditText) promptsView.findViewById(R.id.start_time);
                endTime = (EditText) promptsView.findViewById(R.id.end_time);
                statuss = (CheckBox) promptsView.findViewById(R.id.chk_status);

                // set dialog message

                startTime.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;

                        mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                startTime.setText(selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);//Yes 24 hour time

                        mTimePicker.setTitle("Select Start Time");

                        mTimePicker.show();

                    }
                });

                endTime.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;

                        mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                endTime.setText(selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);//Yes 24 hour time

                        mTimePicker.setTitle("Select End Time");

                        mTimePicker.show();

                    }
                });
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("ADD",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        String nam = names.getText().toString();
                                        String sTime = startTime.getText().toString();
                                        String eTime = endTime.getText().toString();
                                        String status = "";
                                        if (statuss.isChecked()) {
                                            status = "1";
                                        } else {
                                            status = "0";
                                        }

                                        if (sTime.length() > 0 && eTime.length() > 0) {
                                            EasyDbHandler db = new EasyDbHandler(getApplicationContext());
                                            db.addEasySchedule(new EasySchedule(nam, sTime, eTime, status));

                                            //set text blank
                                            names.setText("");
                                            startTime.setText("");
                                            endTime.setText("");
                                            statuss.setChecked(false);
                                            // Hiding the keyboard
                                            InputMethodManager imm = (InputMethodManager)
                                                    getSystemService(Context.INPUT_METHOD_SERVICE);
                                            imm.hideSoftInputFromWindow(names.getWindowToken(), 0);
                                            imm.hideSoftInputFromWindow(startTime.getWindowToken(), 0);
                                            imm.hideSoftInputFromWindow(endTime.getWindowToken(), 0);
                                            imm.hideSoftInputFromWindow(statuss.getWindowToken(), 0);
                                            loadContacts();
                                        } else {

                                            Toast.makeText(getApplicationContext(), "Insert Time", Toast.LENGTH_SHORT).show();


                                        }
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });

        // promt end
        loadContacts();
       /* btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam = names.getText().toString();
                String sTime = startTime.getText().toString();
                String eTime = endTime.getText().toString();
                String status = "";
                if (statuss.isChecked()) {
                    status = "1";
                } else {
                    status = "0";
                }

                if (sTime.length() > 0 && eTime.length() > 0) {
                    EasyDbHandler db = new EasyDbHandler(getApplicationContext());
                    db.addEasySchedule(new EasySchedule(nam, sTime, eTime, status));

                    //set text blank
                    names.setText("");
                    startTime.setText("");
                    endTime.setText("");
                    statuss.setChecked(false);
                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(names.getWindowToken(), 0);
                    imm.hideSoftInputFromWindow(startTime.getWindowToken(), 0);
                    imm.hideSoftInputFromWindow(endTime.getWindowToken(), 0);
                    imm.hideSoftInputFromWindow(statuss.getWindowToken(), 0);
                    loadContacts();
                } else {

                    Toast.makeText(getApplicationContext(), "Insert Time", Toast.LENGTH_SHORT).show();


                }
            }
        });
*/
        listviews.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                EasyDbHandler db = new EasyDbHandler(getApplicationContext());

                List<EasySchedule> easySchedules = db.getAllEasySchedule();


                    db.deleteEasySchedule(new EasySchedule(easySchedules.get(position).getId()));




            //    System.out.println("adapterView.getId() or id: " + adapterView.getId());
             //   db.deleteEasySchedule(new EasySchedule(adapterView.getId()));

                loadContacts();
                Toast.makeText(MainActivity.this,
                        "Item in position " + easySchedules.get(position).getId() + " deleted",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
/*

       listviews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this,
                        "Item in position " + position + " clicked",
                        Toast.LENGTH_SHORT).show();

            }
        });

*/


    }

    private void loadContacts() {
        EasyDbHandler db = new EasyDbHandler(getApplicationContext());
        List<EasySchedule> easySchedules = db.getAllEasySchedule();
        for (EasySchedule es : easySchedules) {
            System.out.println("Id: " + es.getId() + " Name: " + es.getName());
        }
        Toast.makeText(this, "List size: " + easySchedules.size(),
                Toast.LENGTH_LONG).show();

        CustomAdapter adapter = new CustomAdapter(this, easySchedules);
        listviews.setAdapter(adapter);

        //http://www.vogella.com/tutorials/AndroidListView/article.html
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        // On selecting a list name
        String label = adapterView.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(adapterView.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
