package com.example.android.videoview;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView simpleVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView); // initiate a video view
/*
        Uri uri = Uri.parse("http://0.s3.envato.com/h264-video-previews/80fad324-9db4-11e3-bf3d-0050569255a8/490527.mp4");
        simpleVideoView.setVideoURI(uri);
        simpleVideoView.start();
*/


        simpleVideoView.setVideoURI(Uri.parse("android.resource://" +getPackageName()+ "/"+R.raw.testvvv));
        simpleVideoView.setMediaController(new MediaController(this));
        simpleVideoView.requestFocus();
        simpleVideoView.start();
    }
}