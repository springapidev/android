package com.coderbd.calljavaapi;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.coderbd.calljavaapi.entity.User;
import com.coderbd.calljavaapi.model.UserModel;

public class AddActivity extends AppCompatActivity {
    EditText fn, ln, e;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add);
            fn = (EditText) findViewById(R.id.edit_first_name);
            ln = (EditText) findViewById(R.id.edit_last_name);
            e = (EditText) findViewById(R.id.edit_email);
            btnAdd = (Button) findViewById(R.id.btnAdd);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        User user = new User();
                        user.setFirstName(fn.getText().toString());
                        user.setLastName(ln.getText().toString());
                        user.setEmail(e.getText().toString());
                        boolean result = new HttpAddUser().execute(user).get();
                        if (result) {
                            Intent intent = new Intent(AddActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            AlertDialog.Builder alBuilder = new AlertDialog.Builder(getApplicationContext());
                            alBuilder.setMessage("Add Failed!!!");
                            alBuilder.create().show();
                        }
                    } catch (Exception e) {
                        AlertDialog.Builder alBuilder = new AlertDialog.Builder(getApplicationContext());
                        alBuilder.setMessage(e.getMessage());
                        alBuilder.create().show();

                    }
                }
            });
        } catch (Exception e) {
            AlertDialog.Builder alBuilder = new AlertDialog.Builder(getApplicationContext());
            alBuilder.setMessage(e.getMessage());
            alBuilder.create().show();

        }


    }

    private class HttpAddUser extends AsyncTask<User, Void, Boolean> {
        @Override
        protected Boolean doInBackground(User... params) {
            UserModel userModel = new UserModel();
            return userModel.create(params[0]);
        }
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}
