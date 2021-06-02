package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.exoplayer.models.Cancion;
import com.example.exoplayer.models.ListaDeReproduccion;
import com.google.android.exoplayer2.MediaItem;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {


    private ArrayList<ListaDeReproduccion>listasDeReproduccion;
    private ArrayList<MediaItem> listaReproduccion = null;
    private ArrayAdapter<MediaItem> adaptador;
    private AdaptadorListaListasDeReproduccion adaptadorListas;

    ListView listaRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        //listaReproduccion = (ArrayList<MediaItem>) getIntent().getSerializableExtra("lista");
        //listaRep = findViewById(R.id.listaView);

        listasDeReproduccion = new ArrayList<ListaDeReproduccion>();

        ListView lista = (ListView) findViewById(R.id.listview_resultados_listas);

        adaptadorListas = new AdaptadorListaListasDeReproduccion(this, R.id.layout_listas_results, listasDeReproduccion);
        lista.setAdapter(adaptadorListas);
        //agregar listaCanciones a listaRep
    }

}