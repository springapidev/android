package com.coderbd.firebaserealdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText username, pass, email;
Button btn;
DatabaseReference databaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseUser = FirebaseDatabase.getInstance().getReference("users");
        username = (EditText)findViewById(R.id.editTextUsername);
        pass = (EditText)findViewById(R.id.editTextPassword);
        email = (EditText)findViewById(R.id.editTextEmail);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString().trim();
                String p = pass.getText().toString().trim();
                String e = email.getText().toString().trim();
                if(!TextUtils.isEmpty(uname)){
                    String id = databaseUser.push().getKey();
                    User user=new User(id, uname,p,e);
                    databaseUser.child(id).setValue(user);
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
