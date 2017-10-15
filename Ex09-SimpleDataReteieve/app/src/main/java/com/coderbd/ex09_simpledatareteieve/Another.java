package com.coderbd.ex09_simpledatareteieve;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Another extends AppCompatActivity {
TextView dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
dis=(TextView)findViewById(R.id.display);

        Intent intent=getIntent();
        String n=intent.getStringExtra("name");
        dis.setText(n);
        System.out.println("name:::::: "+n);

    }
}
