package com.coderbd.browseactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText txtName;
    Button btn;
    RadioButton genBtn;
    String gender = null;
    RadioGroup rGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button) findViewById(R.id.btnHome);


        txtName = (EditText) findViewById(R.id.name);


        rGender = (RadioGroup) findViewById(R.id.rGender);
        // get selected radio button from radioGroup
        int selectedId = rGender.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        genBtn = (RadioButton) findViewById(selectedId);
        gender = genBtn.getText().toString();
        System.out.println("=========="+gender);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Another.class);

                String n = txtName.getText().toString();
                intent.putExtra("name", n);
               // intent.putExtra("gend", gender);

                startActivity(intent);
            }
        });

    }


}
