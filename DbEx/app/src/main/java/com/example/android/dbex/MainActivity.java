package com.example.android.dbex;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener{
    Spinner spinner;
    Button btnAdd;
    EditText inputLabel;
    List<String> list;
    ListView listviews;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listviews=(ListView)findViewById(R.id.listview);

        list=new ArrayList<String>();

        spinner = (Spinner) findViewById(R.id.spinner);
        btnAdd = (Button) findViewById(R.id.btn_add);
        inputLabel = (EditText) findViewById(R.id.input_label);

        spinner.setOnItemSelectedListener(this);

        // Loading spinner data from database
        loadSpinnerData();

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String label = inputLabel.getText().toString();
Contact contact=new Contact(label);

                if (label.trim().length() > 0) {
                    DBHelper db = new DBHelper(getApplicationContext());
                    db.insertLabel(contact);

                    // making input filed text to blank
                    inputLabel.setText("");

                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(inputLabel.getWindowToken(), 0);

                    // loading spinner with newly added data
                    loadSpinnerData();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter label name",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    /**
     * Function to load the spinner data from SQLite database
     * */
    private void loadSpinnerData() {
        DBHelper db = new DBHelper(getApplicationContext());
        List<String> labels = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        //list
        list=db.getAllLabels();
        ArrayAdapter<String> dataAdapterForList = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        listviews.setAdapter(dataAdapterForList);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }





}