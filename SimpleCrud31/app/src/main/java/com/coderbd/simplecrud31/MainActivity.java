package com.coderbd.simplecrud31;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText id, contactName, mobileno, emaill;
    ListView listviews;
    Button btnAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        contactName = (EditText) findViewById(R.id.name);
        mobileno = (EditText) findViewById(R.id.mobile);
        emaill = (EditText) findViewById(R.id.email);

        listviews = (ListView) findViewById(R.id.listview);
        btnAd = (Button) findViewById(R.id.btnAdd);
        loadContacts();
        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String idss = id.getText().toString();
                String name = contactName.getText().toString();
                String mobilen = mobileno.getText().toString();
                String emaix = emaill.getText().toString();
                if (name.length() > 0) {
                    DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                    db.addContact(new Contact(name, mobilen,emaix));

                    //set text blank
                    contactName.setText("");
                    mobileno.setText("");
                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(contactName.getWindowToken(), 0);
                    imm.hideSoftInputFromWindow(mobileno.getWindowToken(), 0);
                    imm.hideSoftInputFromWindow(emaill.getWindowToken(), 0);
                    loadContacts();
                } else {

                    Toast.makeText(getApplicationContext(), "Insert Name", Toast.LENGTH_SHORT).show();


                }
            }
        });

        listviews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.deleteContact(new Contact(position+1));
                Toast.makeText(MainActivity.this,
                        "Item in position " + position + " deleted",
                        Toast.LENGTH_SHORT).show();


            }
        });


     /*   listviews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        List<Contact> contacts = db.getAllContacts();

        Toast.makeText(this, "List size: " + contacts.size(),
                Toast.LENGTH_LONG).show();

        MyAdapter adapter = new MyAdapter(this, contacts);
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
