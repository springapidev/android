package com.coderbd.ex06_moreactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondAcitity extends AppCompatActivity {
    private Button btnSc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitity);
        Intent intent=getIntent();
        String n=intent.getStringExtra("v1");
        boolean m=Boolean.parseBoolean(intent.getStringExtra("v2"));
        double o=Double.parseDouble(intent.getStringExtra("v3"));
        double x=300.0;
        double sum=o+x;
// Check Log activity to see the result
        System.out.println("m: "+m);
        System.out.println("n: "+n);
        System.out.println("o: "+o);
        System.out.println("sum: "+sum);

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
