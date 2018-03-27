package com.coderbd.soundless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.AudioManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar voice = null;
    private SeekBar music = null;
    private SeekBar ring = null;
    private SeekBar alarm = null;
    private SeekBar system = null;
    private AudioManager mgr = null;
    private RadioGroup rGroup;
    private RadioButton normalMode;
    private RadioButton silentMode;
    private RadioButton vibrateMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mgr=(AudioManager)getSystemService(getApplicationContext().AUDIO_SERVICE);
        rGroup = (RadioGroup)findViewById(R.id.vibrate_control);
        normalMode = (RadioButton)findViewById(R.id.normal_mode);
        silentMode = (RadioButton)findViewById(R.id.silent_mode);
        vibrateMode = (RadioButton)findViewById(R.id.vibrate_mode);
        voice = (SeekBar)findViewById(R.id.voice_control);
        music = (SeekBar)findViewById(R.id.music_control);
        ring = (SeekBar)findViewById(R.id.ringing_control);
        alarm = (SeekBar)findViewById(R.id.alarm_control);
        system = (SeekBar)findViewById(R.id.system_control);
        initBar(alarm, AudioManager.STREAM_ALARM);
        initBar(music, AudioManager.STREAM_MUSIC);
        initBar(ring, AudioManager.STREAM_RING);
        initBar(system, AudioManager.STREAM_SYSTEM);
        initBar(voice, AudioManager.STREAM_VOICE_CALL);
        setAudioMode();
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = group.indexOfChild(findViewById(group.getCheckedRadioButtonId()));
                System.out.println("Selected Button id " + index);
                if (checkedId == R.id.normal_mode) {
                    mgr.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    normalMode.setChecked(true);
                }
                if (checkedId == R.id.silent_mode) {
                    mgr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                    silentMode.setChecked(true);
                }
                if (checkedId == R.id.vibrate_mode) {
                    mgr.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                    vibrateMode.setChecked(true);
                }
            }
        });
    }
    private void setAudioMode(){
        System.out.println("Current Ringing Mode " + mgr.getMode());
        if(mgr.getRingerMode() == 0){
            mgr.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            normalMode.setChecked(true);
        }
        if(mgr.getMode() == 1){
            mgr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            silentMode.setChecked(true);
        }
        if(mgr.getMode() == 2){
            mgr.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            vibrateMode.setChecked(true);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sound_test, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initBar(SeekBar bar, final int stream) {
        bar.setMax(mgr.getStreamMaxVolume(stream));
        bar.setProgress(mgr.getStreamVolume(stream));
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
                mgr.setStreamVolume(stream, progress, AudioManager.FLAG_PLAY_SOUND);
            }
            public void onStartTrackingTouch(SeekBar bar) {
            }
            public void onStopTrackingTouch(SeekBar bar) {
            }
        });
    }
}