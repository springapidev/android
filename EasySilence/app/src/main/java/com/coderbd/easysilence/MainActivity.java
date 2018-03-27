package com.coderbd.easysilence;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    RadioButton ring,vibrate,silent;
    private AudioManager myAudioManager;
    TextView tvStatus;

Button btnRate, btnContact, btnMoreApps;
Context context;

    // Remove the below line after defining your own ad unit ID.
    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";
//weekly schedule Activty
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        silent=(RadioButton)findViewById(R.id.r_silent);
        vibrate=(RadioButton)findViewById(R.id.r_vibrate);
        ring=(RadioButton)findViewById(R.id.r_ring);

        tvStatus=(TextView)findViewById(R.id.tv_status);


        myAudioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);


        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                tvStatus.setText(vibrate.getText());
            }
        });
        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                tvStatus.setText(silent.getText());
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                tvStatus.setText(ring.getText());
            }
        });

        int mod=myAudioManager.getRingerMode();
        if(mod==AudioManager.RINGER_MODE_VIBRATE){
            tvStatus.setText(vibrate.getText());
            vibrate.setChecked(true);
        }else if(mod==AudioManager.RINGER_MODE_SILENT){
            tvStatus.setText(silent.getText());
            silent.setChecked(true);
        }else{
            tvStatus.setText(ring.getText());
            ring.setChecked(true);
        }
        //For Bottom Button
        btnRate=(Button)findViewById(R.id.btn_rate);
        btnContact=(Button)findViewById(R.id.btn_contact);
        btnMoreApps=(Button)findViewById(R.id.btn_more);
        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context=getApplicationContext();
                Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                          Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
                         //ok   Uri.parse("http://play.google.com")));
                }
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http:/coderbd.com")));
            }
        });

        btnMoreApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/developer?id=Applzz,LLC")));

            }
        });
//adds
        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
        Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();

imageView=(ImageView)findViewById(R.id.ic);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WeeklyScheduleActivity.class);
                startActivity(intent);
            }
        });
    }
   }
