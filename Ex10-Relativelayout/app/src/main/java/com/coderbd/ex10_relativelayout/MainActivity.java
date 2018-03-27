package com.coderbd.ex10_relativelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
          //  final EditText uname=(EditText)findViewById(R.id.username);
             final RadioButton mal=(RadioButton)findViewById(R.id.male);
            final RadioButton femal=(RadioButton)findViewById(R.id.female);
            Button btnAdd=(Button)findViewById(R.id.btnadd);
        final TextView tvdis=(TextView)findViewById(R.id.tv);

            final TextView tvdis2=(TextView)findViewById(R.id.tv2);
            final CheckBox read=(CheckBox)findViewById(R.id.reading);
            final CheckBox writ=(CheckBox)findViewById(R.id.writing);


            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(mal.isChecked()){
                        tvdis.setText(mal.getText());
                    }else if(femal.isChecked()){
                        tvdis.setText(femal.getText());
                    }else{
                        tvdis.setText("No Check Yet");

                    }

                    //Check Box Data Display
                    String hobby="";
                    if(read.isChecked()){
                        hobby+=read.getText()+", ";
                    }
                    if(writ.isChecked()){
                       hobby+=writ.getText();
                    }
                    if (hobby.endsWith(",")) {
                        hobby = hobby.substring(0, hobby.length() - 1);
                    }
                    tvdis2.setText(hobby);



                }
            });




               }

    }