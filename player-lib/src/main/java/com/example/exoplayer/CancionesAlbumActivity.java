package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.exoplayer.models.Cancion;

import java.util.ArrayList;

public class CancionesAlbumActivity extends AppCompatActivity {

    ArrayList<Cancion>cancionesAlbum;
    AdaptadorCancionesAlbum adaptadorCancionesAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones_album);
        cancionesAlbum = new ArrayList<>();
        ListView lista = (ListView) findViewById(R.id.listview_canciones_album);
        adaptadorCancionesAlbum = new AdaptadorCancionesAlbum(this, R.id.layout_listasDetail_results, cancionesAlbum);
        lista.setAdapter(adaptadorCancionesAlbum);
    }
}