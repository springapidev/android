package com.coderbd.calljavaapi;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.coderbd.calljavaapi.entity.User;
import com.coderbd.calljavaapi.model.UserModel;

public class DetailActivity extends AppCompatActivity {
    TextView fn, ln, e;
    Button btnEdit, btnDel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);
            fn = (TextView) findViewById(R.id.view_first_name);
            ln = (TextView) findViewById(R.id.view_last_name);
            e = (TextView) findViewById(R.id.view_email);
            btnEdit = (Button) findViewById(R.id.btnEdit);

            Intent intent = getIntent();
            final User user = (User) intent.getSerializableExtra("user");
            fn.setText(user.getFirstName());
            ln.setText(user.getLastName());
            e.setText(user.getEmail());
            System.out.println("ID::::: "+user.getId());

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(DetailActivity.this, EditActivity.class);
                    intent1.putExtra("user",user);
                    startActivity(intent1);
                }
            });

            btnDel = (Button) findViewById(R.id.btnDel);
            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        boolean result = new HttpRequestDetail().execute(user.getId()).get();
                        if (result) {
                            Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
                            startActivity(intent1);
                        }else{
                            AlertDialog.Builder alBuilder = new AlertDialog.Builder(getApplicationContext());
                            alBuilder.setMessage("Delete Failed!!!");
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


    private class HttpRequestDetail extends AsyncTask<Long, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Long... longs) {
            UserModel userModel = new UserModel();
            return userModel.delete(longs[0]);
        }
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}
