package com.coderbd.ex05_buttontoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btn;
    private TextView sText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.btn);
        sText=(TextView)findViewById(R.id.show_toast_id);

    }
    public void showToast(View view){
        Toast.makeText(getApplicationContext(),R.string.show_toast_msg, Toast.LENGTH_SHORT).show();
        //remove it after checking
        sText.append("Ok");
    }

}
