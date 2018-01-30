package com.coderbd.camerafalshlight;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.security.Policy;

import static android.content.DialogInterface.*;

public class MainActivity extends AppCompatActivity {
private Camera camera;
    private boolean isFlashOn;
    private  boolean hasFlash;
    Policy.Parameters param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hasFlash=getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if(!hasFlash){
            AlertDialog alert=new AlertDialog.Builder(this).create();
            alert.setTitle("Error");
            alert.setMessage("Your Device not support Flash Light");
            alert.setButton("OK",new OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    finish();
                }
            });
            alert.show();
        }

    }
}
