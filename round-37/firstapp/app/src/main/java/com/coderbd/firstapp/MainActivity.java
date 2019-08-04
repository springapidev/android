package com.coderbd.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn, btnUsa;
    EditText username, pass;
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout_ex);
        username=(EditText)findViewById(R.id.editUsername);
        pass=(EditText)findViewById(R.id.editPassword);
        msg=(TextView) findViewById(R.id.txtStatus);
//
//        btn=(Button)findViewById(R.id.btnAdd);
//        btnUsa=(Button)findViewById(R.id.btnUSA);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              //  Toast.makeText(MainActivity.this, "Dengu Is spread all over Bd", Toast.LENGTH_SHORT).show();
//          btnUsa.setText("USA");
//            }
//        });


    }
public void login(View view){
        if (username.getText().toString().equalsIgnoreCase("admin") && pass.getText().toString().equalsIgnoreCase("1234")){
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
            msg.setText("");
        }else {
            msg.setText("U or P inValid!!");
        }

}
    public void clickMe(View view){
        Toast.makeText(this, "Oh No, Why you click Me?", Toast.LENGTH_SHORT).show();
    }
}
