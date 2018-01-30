package com.coderbd.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView simpleListView;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleListView=(ListView)findViewById(R.id.simpleListViews);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.listonlytext,R.id.textView2, countryList);
        simpleListView.setAdapter(adapter);
    }
}
