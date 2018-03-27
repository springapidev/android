package com.coderbd.ex09_audiomanager;

import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button mode,ring,vibrate,silent, mediaMode, netOff;
    private AudioManager myAudioManager;
    ToggleButton toggleButton;
//Internet Checking
    ConnectivityManager conMgr;

    WifiManager wifi;
    Context context;

TextView tvStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actual_layout);
        silent=(RadioButton)findViewById(R.id.r_silent);
        vibrate=(RadioButton)findViewById(R.id.r_vibrate);
        ring=(RadioButton)findViewById(R.id.r_ring);

        tvStatus=(TextView)findViewById(R.id.tv_status);
       silent.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               tvStatus.setText(silent.getText());
           }
       });

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvStatus.setText(vibrate.getText());
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvStatus.setText(ring.getText());
            }
        });

        /*
        mode=(Button)findViewById(R.id.button);
        ring=(Button)findViewById(R.id.button2);
        vibrate=(Button)findViewById(R.id.button3);
        silent=(Button)findViewById(R.id.button4);


        mediaMode=(Button)findViewById(R.id.button5);



        myAudioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);


        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(MainActivity.this,"Now in Vibrate Mode",Toast.LENGTH_SHORT).show();
            }
        });
        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(MainActivity.this,"Now in Silent Mode",Toast.LENGTH_SHORT).show();
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(MainActivity.this,"Now in Ring Modem , normal",Toast.LENGTH_SHORT).show();
            }
        });
        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mod=myAudioManager.getRingerMode();
                if(mod==AudioManager.RINGER_MODE_VIBRATE){
                    Toast.makeText(MainActivity.this,"Now in Vibrate Mode",Toast.LENGTH_SHORT).show();
                }else if(mod==AudioManager.RINGER_MODE_SILENT){
                    Toast.makeText(MainActivity.this,"Now in Silent Mode",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Now in Ring Mode",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Internet........
        netOff=(Button)findViewById(R.id.btn_net_off);
       mediaMode.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
               NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
               if(networkInfo != null && networkInfo.isConnected()==true )
               {
                   Toast.makeText(MainActivity.this, getResources().getString(R.string.internet_status), Toast.LENGTH_LONG).show();

               }
               else
               {
                   Toast.makeText(MainActivity.this, getResources().getString(R.string.internet_error), Toast.LENGTH_LONG).show();

               }

           }

       });
        /*
        netOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // wifi = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
              //  wifi.setWifiEnabled(false);
                TelephonyManager tMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String mPhoneNumber = tMgr.getLine1Number();
                Toast.makeText(getApplicationContext(),"My Number is: "+mPhoneNumber,Toast.LENGTH_SHORT).show();
            }
        });
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    wifi = (WifiManager) context.getApplicationContext().getSystemService(context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                Toast.makeText(getApplicationContext(),"WiFi now is ON",Toast.LENGTH_SHORT).show();

                } else {
                    wifi = (WifiManager) context.getApplicationContext().getSystemService(context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                    Toast.makeText(getApplicationContext(),"WiFi now is ON",Toast.LENGTH_SHORT).show();
                }
            }
        });
        */


    }
    private String getMyPhoneNO() {
        TelephonyManager tMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String mPhoneNumber = tMgr.getLine1Number();
        return mPhoneNumber;
    }
}
