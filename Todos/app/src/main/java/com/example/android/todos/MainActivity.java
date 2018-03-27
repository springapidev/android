package com.example.android.todos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ite;
    Button btn;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ite=(EditText)findViewById(R.id.item);
        btn=(Button)findViewById(R.id.btn);
        listView=(ListView)findViewById(R.id.itemlistView);

        list=new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item=ite.getText().toString();
                if(item.length()>0){
                    list.add(ite.getText().toString());

                    arrayAdapter.notifyDataSetChanged();
                    ite.setText("");
                }
            }
        });

      /*  listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                arrayAdapter.notifyDataSetChanged();

                return true;
            }
        });
        */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
