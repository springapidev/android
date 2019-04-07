package com.coderbd.broadcastrecieverex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.Toast;

/**
 * Created by Rajaul Islam
 */

public class MyCancelBroadcastReceiver extends BroadcastReceiver {
private Context context;
    private AudioManager myAudioManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        makePhoneNormal();
        Toast.makeText(context, "Normal....", Toast.LENGTH_LONG).show();
    }
    public void makePhoneNormal(){
        myAudioManager=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

    }

}