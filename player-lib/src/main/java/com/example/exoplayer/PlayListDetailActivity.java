package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.exoplayer.models.ListaDeReproduccion;

public class PlayListDetailActivity extends AppCompatActivity {

    public String EXTRA_MESSAGE = "playlist";
    public ListaDeReproduccion playlistSeleccionada;
    public AdaptadorListasDeRerpoduccionDetail  adaptadorListasDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_detail);
        playlistSeleccionada = (ListaDeReproduccion) getIntent().getSerializableExtra("playlist");
        ListView lista = (ListView) findViewById(R.id.listview_resultados_canciones_listas);
        adaptadorListasDetail = new AdaptadorListasDeRerpoduccionDetail(this, R.id.layout_listasDetail_results, playlistSeleccionada.getCancionesPlaylist());
        lista.setAdapter(adaptadorListasDetail);
    }

    private void abrirActivity(Class activityParaAbrir) {

        Intent intent = new Intent(this, activityParaAbrir);
        //String message = "Bingo";
        intent.putExtra(EXTRA_MESSAGE, playlistSeleccionada);
        startActivity(intent);
    }
}