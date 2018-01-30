package com.coderbd.datapass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {
TextView dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        dis=(TextView)findViewById(R.id.textView8);

        Intent intent=getIntent();
        String n=intent.getStringExtra("nadia");
        dis.setText(n);

    }
}
