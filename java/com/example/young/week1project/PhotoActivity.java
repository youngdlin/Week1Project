package com.example.young.week1project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PhotoActivity extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        imageView=(ImageView)findViewById(R.id.imageView);
        Intent receivedIntent = getIntent();
        Uri image = receivedIntent.getParcelableExtra(MainActivity.IMAGE_KEY);
        imageView.setImageURI(image);

    }

}
