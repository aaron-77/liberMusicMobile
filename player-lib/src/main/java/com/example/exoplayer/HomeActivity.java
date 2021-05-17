package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerActivity = new Intent(HomeActivity.this,PlayerActivity.class);
                playerActivity.putExtra("cancion",items.get(position));
                startActivity(playerActivity);
            }
        });

    }
    public void refreshList() {
        if (adaptadorListaExplorarCanciones != null) {
            adaptadorListaExplorarCanciones.notifyDataSetChanged();
        }
    }
}