package com.coderbd.ex12_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
ListView simpleListView;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
    int flags[] = {android.R.mipmap.sym_def_app_icon,android.R.mipmap.sym_def_app_icon, android.R.mipmap.sym_def_app_icon,android.R.mipmap.sym_def_app_icon,android.R.mipmap.sym_def_app_icon,android.R.mipmap.sym_def_app_icon};

   Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleListView=(ListView)findViewById(R.id.simpleListView);
        simpleListView = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
        simpleListView.setAdapter(customAdapter);

        btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SimpleList.class);
                startActivity(intent);
            }
        });

    }
}
