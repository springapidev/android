package com.coderbd.oauthconsumetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.coderbd.oauthconsumetest.api.OAuth2Client;
import com.coderbd.oauthconsumetest.api.Token;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OAuth2Client client = new OAuth2Client("admin", "123456", "client", "secret", "http://localhost:8080");
       String token=client.getAccessToken().toString();
       System.out.println("Reza Token: "+token);
       // token.getResource(client, token, "/path/to/resource?name=value");
    }
}
