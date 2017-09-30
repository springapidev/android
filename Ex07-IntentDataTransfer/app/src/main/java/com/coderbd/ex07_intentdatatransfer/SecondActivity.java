package com.coderbd.ex07_intentdatatransfer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
private Button sBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitity);

        sBtn=(Button)findViewById(R.id.btn_second);
        ArrayList<Person> myList = (ArrayList<Person>) getIntent().getSerializableExtra("personList");
      //  Toast.makeText(this, list.get(0).getName(), Toast.LENGTH_LONG).show();
   for(Person p : myList){
       System.out.println("name: "+p.getName()+ ", Age: "+p.getAge());
   }

        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
