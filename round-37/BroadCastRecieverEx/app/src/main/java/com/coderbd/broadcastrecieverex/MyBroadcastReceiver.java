package com.coderbd.broadcastrecieverex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;


public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    private Context context;
    private AudioManager myAudioManager;
    @Override
    public void onReceive(Context context, Intent intent) {
    mp=MediaPlayer.create(context, R.raw.alrm );
      mp.start();
        //makePhoneSilent();
        //Toast.makeText(context, "Silence....", Toast.LENGTH_LONG).show();

    }
    public void makePhoneSilent(){
        myAudioManager=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }
}