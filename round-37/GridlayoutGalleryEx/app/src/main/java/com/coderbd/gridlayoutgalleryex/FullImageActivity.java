package com.coderbd.gridlayoutgalleryex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullImageActivity extends AppCompatActivity {
    ImageView fullImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);
        fullImage=(ImageView)findViewById(R.id.full_image_view);
        Intent intent=getIntent();
        // Selected image id
        int position = intent.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);
        fullImage.setImageResource(imageAdapter.thumbs[position]);

    }
}
