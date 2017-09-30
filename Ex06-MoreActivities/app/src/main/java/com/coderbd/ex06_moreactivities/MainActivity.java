package com.coderbd.ex06_moreactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain=(Button)findViewById(R.id.btn_main);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SecondAcitity.class);
                intent.putExtra("v1","Reza");
                intent.putExtra("v2","true");
                intent.putExtra("v3","500.0");
             startActivity(intent);

            }
        });
    }
}
