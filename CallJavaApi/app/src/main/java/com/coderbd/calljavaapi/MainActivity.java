package com.coderbd.calljavaapi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.coderbd.calljavaapi.adapter.UserAdapter;
import com.coderbd.calljavaapi.entity.User;
import com.coderbd.calljavaapi.model.UserModel;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final List<User> users=new HttpRequestUserList().execute().get();
            System.out.println("size of List: "+users.size());

            for(User u : users){
                System.out.println(u);
            }
            ListView listView=(ListView)findViewById(R.id.user_list);
            listView.setAdapter(new UserAdapter(users, getApplicationContext()));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("user",users.get(position));
                    startActivity(intent);

                }
            });

            Button btn=(Button)findViewById(R.id.btnGoAdd);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this, AddActivity.class);
                    startActivity(intent);
                }
            });



        }catch (Exception e){

            AlertDialog.Builder alBuilder=new AlertDialog.Builder(getApplicationContext());
            alBuilder.setMessage(e.getMessage());
            alBuilder.create().show();
        }



    }

    private class HttpRequestUserList extends AsyncTask<Void, Void, List<User>>{


        @Override
        protected List<User> doInBackground(Void... voids) {
            UserModel userModel=new UserModel();
            System.out.println("userModel.findAll() size::: "+userModel.findAll().size());
            return userModel.findAll();
                   }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
        }
    }
}