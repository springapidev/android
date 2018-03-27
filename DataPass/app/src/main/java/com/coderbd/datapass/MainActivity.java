package com.coderbd.datapass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (EditText) findViewById(R.id.editText2);
    }

    public void gotoDisplay(View view) {
        Intent intent = new Intent(this, Display.class);
        String nnn = txtName.getText().toString();

        intent.putExtra("nadia", nnn);
        startActivity(intent);

    }

}
