package com.coderbd.ex07_intentdatatransfer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Button mBtn;
    ArrayList<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   personList=new ArrayList<>();
        personList.add(new Person("Reza",36));
        personList.add(new Person("Sejuti",11));
        personList.add(new Person("Sayonti",7));
        personList.add(new Person("Sami",1));
        personList.add(new Person("Reyasha",11));
        personList.add(new Person("Ridiya",7));

        mBtn=(Button)findViewById(R.id.btn_main);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("personList",personList);
                startActivity(intent);
            }
        });
}
}
