package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.exoplayer.models.Cancion;
import com.example.exoplayer.requests.ManagerRequest;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ListView contactosList;
    AdaptadorListaBuscador adaptadorListaExplorarCanciones;
    ManagerRequest.QueueObject queque = null;
    ArrayList<Cancion> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        items = new ArrayList<Cancion>();
        queque = ManagerRequest.getInstance(this);
        ListView lista = (ListView) findViewById(R.id.list_results_search);
        Cancion.explorarCanciones(queque,items,this);
        adaptadorListaExplorarCanciones = new AdaptadorListaBuscador(this, R.id.layout_list_results, items);
        lista.setAdapter(adaptadorListaExplorarCanciones);

    }
    public void refreshList() {
        if (adaptadorListaExplorarCanciones != null) {
            adaptadorListaExplorarCanciones.notifyDataSetChanged();
        }
    }
}