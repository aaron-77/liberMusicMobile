package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.exoplayer2.MediaItem;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
    }


    public void clicRegreso(View view)
    {
        Intent regreso = new Intent(this, HomeActivity.class);
        startActivity(regreso);
    }

    public ArrayList<MediaItem> clicReproducir (View view)
    {
         Intent reproduccion = new Intent(this, PlayerActivity.class);
        startActivity(reproduccion);
        return null;
    }
}