package com.coderbd.sqlietdbex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
MyDbAdapter myDbAdapter;
TextView productID, productName, quantiy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        productID=(TextView)findViewById(R.id.id);
        productName=(TextView)findViewById(R.id.pname);
        quantiy=(TextView)findViewById(R.id.qty);


        Intent intent=getIntent();
        int position = intent.getExtras().getInt("pos");
        myDbAdapter = new MyDbAdapter(this);
        int id=position + 1;
        System.out.println(position);
        Product product=myDbAdapter.findProductById(id);
        System.out.println(product);
        productID.setText(String.valueOf(product.getId()));
        productName.setText(String.valueOf(product.getProductname()));
        quantiy.setText(String.valueOf(product.getQuantity()));

    }
}
