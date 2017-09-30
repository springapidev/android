package com.coderbd.ex06_moreactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondAcitity extends AppCompatActivity {
    private Button btnSc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitity);

        btnSc=(Button)findViewById(R.id.btn_second);
        btnSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(SecondAcitity.this, MainActivity.class);
                startActivity(in);
            }
        });
    }
}
