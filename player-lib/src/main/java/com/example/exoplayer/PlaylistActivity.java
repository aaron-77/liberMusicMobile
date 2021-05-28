package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.exoplayer.models.Cancion;
import com.google.android.exoplayer2.MediaItem;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    private ArrayList<Cancion> listaCanciones = null;
    private ArrayList<MediaItem> listaReproduccion = null;
    private ArrayAdapter<MediaItem> adaptador;
    ListView listaRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        listaReproduccion = (ArrayList<MediaItem>) getIntent().getSerializableExtra("lista");
        listaRep = findViewById(R.id.listaView);
        //agregar listaCanciones a listaRep
    }

}