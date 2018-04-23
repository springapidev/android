package com.coderbd.restapidisplaylist;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.coderbd.restapidisplaylist.adapter.UserListAdapter;
import com.coderbd.restapidisplaylist.entity.User;
import com.coderbd.restapidisplaylist.model.UserModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            final List<User> users=new HttpRequestUserList().execute().get();
            ListView listView=(ListView)findViewById(R.id.user_list);
            listView.setAdapter(new UserListAdapter(getApplicationContext(), users));

        }catch (Exception e){
            AlertDialog.Builder alBuilder=new AlertDialog.Builder(getApplicationContext());
            alBuilder.setMessage(e.getMessage());
            alBuilder.create().show();

        }


    }

    public class HttpRequestUserList extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... voids) {
            UserModel userModel=new UserModel();
            return userModel.findAll();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
        }
    }
}
