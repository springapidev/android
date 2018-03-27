package com.coderbd.androidapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.coderbd.androidapi.api.OAuth2Client;
import com.coderbd.androidapi.api.Token;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OAuth2Client client = new OAuth2Client("demouser", "testpass", "demoapp", "demopass", "http://brentertainment.com");
        Token token = client.getAccessToken();
        System.out.println("Reza Token: "+token);
       // token.getResource(client, token, "/path/to/resource?name=value");
    }
}
