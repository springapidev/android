package com.coderbd.ex07_intentdatatransfer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private Button sBtn;
    private ListView pList;
    TextView vPersonName;

private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitity);

       pList=(ListView)findViewById(R.id.listview_person);

        sBtn=(Button)findViewById(R.id.btn_second);
        ArrayList<Person> myList = (ArrayList<Person>) getIntent().getSerializableExtra("personList");
      // Toast.makeText(this, list.get(0).getName(), Toast.LENGTH_LONG).show();
    personAdapter=new PersonAdapter(SecondActivity.this, myList);

    pList.setAdapter(personAdapter);

/*
        vPersonName=(TextView)findViewById(R.id.person_name);
   for(Person p : myList){
     //  vPersonName.setText(p.getName());
       System.out.println("name: "+p.getName()+ ", Age: "+p.getAge());
   }

*/


        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
