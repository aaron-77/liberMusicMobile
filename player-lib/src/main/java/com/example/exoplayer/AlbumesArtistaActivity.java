package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.exoplayer.models.Cancion;
import com.example.exoplayer.models.ListaDeReproduccion;

import java.util.ArrayList;

public class AlbumesArtistaActivity extends AppCompatActivity {
    ArrayList<Cancion>albumes;
    AdaptadorAlbumesArtista adaptadorAlbumesArtista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        albumes = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albumes_artista);
        ListView lista = (ListView) findViewById(R.id.listview_albumes_artista);
        adaptadorAlbumesArtista = new AdaptadorAlbumesArtista(this, R.id.layout_albumesArtista_results, albumes);
        lista.setAdapter(adaptadorAlbumesArtista);

    }
}