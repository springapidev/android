package com.coderbd.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float height;
    private float weight;
    private float bmi;

    EditText editHeight, editWeight;
    Button buttonCal;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editHeight=(EditText)findViewById(R.id.height);
        editWeight=(EditText)findViewById(R.id.weight);

        buttonCal =(Button)findViewById(R.id.btnCal);
        result =(TextView)findViewById(R.id.rs);


        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editHeight.getText().length() > 0 && editWeight.getText().length() > 0){

                    height = Float.parseFloat(editHeight.getText().toString());
                    weight = Float.parseFloat(editWeight.getText().toString());
                    bmi = calculateBMI(weight,height);

                    if(bmi < 16){
                        result.setText("Your BMI: "+bmi + "Severely under weight");
                    }else  if(bmi < 18.5){
                        result.setText("Your BMI: "+bmi + "Under weight");
                    }else  if(bmi < 25){
                        result.setText("Your BMI: "+bmi + "Normal");
                    }else  if(bmi < 30){
                        result.setText("Your BMI: "+bmi + "Over weight");
                    }else {
                        result.setText("Your BMI: "+bmi + "Obec");
                    }
                }
            }
        });



    }


    public float calculateBMI(float weight, float height){
        height = (height / 100);
        return (float)(weight/(height * height));

    }






}
