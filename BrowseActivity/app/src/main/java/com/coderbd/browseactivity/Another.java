package com.coderbd.browseactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Another extends AppCompatActivity {
    TextView dis, disGen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        dis = (TextView) findViewById(R.id.displayName);
        disGen = (TextView) findViewById(R.id.displayGender);

        Intent intent = getIntent();
        String n = intent.getStringExtra("name");
        String gender = intent.getStringExtra("gend");

        dis.setText(n);
        disGen.setText(gender);
        System.out.println("name:::::: " + n);
        System.out.println("name:::::: " + gender);
    }

    public void goToHome(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}
