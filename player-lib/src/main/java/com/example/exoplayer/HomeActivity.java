package com.example.exoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.exoplayer.controllers.ListasDeReproduccionController;
import com.example.exoplayer.models.Cancion;
import com.example.exoplayer.requests.ManagerRequest;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ListView contactosList;
    AdaptadorListaBuscador adaptadorListaExplorarCanciones;
    ManagerRequest.QueueObject queque = null;
    ArrayList<Cancion> items;
    private BottomNavigationView barraDeNavegacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        barraDeNavegacion = findViewById(R.id.bottom_navigation);
        barraDeNavegacion.setSelectedItemId(R.id.page_1);
        barraDeNavegacion.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int idMenuItemSeleccionado=menuItem.getItemId();
                int menuPagina1= R.id.page_1;
                boolean isSelected= false;

                if (idMenuItemSeleccionado == R.id.page_1) {
                    // no se hace nada es el activity home actual
                    isSelected= true;
                } else if (idMenuItemSeleccionado == R.id.page_2) {
                    abrirActivity(PlayerActivity.class);
                    isSelected= true;
                }else if(idMenuItemSeleccionado == R.id.page_3){
                    //llamar activity listas de reproduccion
                    isSelected= true;
                }else if(idMenuItemSeleccionado == R.id.page_4){
                    //llamar activity buscador
                }else if (idMenuItemSeleccionado == R.id.page_5){
                    abrirActivity(CuentaActivity.class);
                }
                return isSelected;
            }

        });
        items = new ArrayList<Cancion>();
        queque = ManagerRequest.getInstance(this);
        ListView lista = (ListView) findViewById(R.id.listview_resultados_listas);
        Cancion.explorarCanciones(queque,items,this);
        adaptadorListaExplorarCanciones = new AdaptadorListaBuscador(this, R.id.layout_listas_results, items);
        lista.setAdapter(adaptadorListaExplorarCanciones);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent playerActivity = new Intent(HomeActivity.this,PlayerActivity.class);
                ArrayList<Cancion>cancionesLista = new ArrayList<Cancion>();
                cancionesLista.add(items.get(position));
                ArrayList<MediaItem> listaDeReproduccionCreada = new ArrayList<MediaItem>();
                listaDeReproduccionCreada = ListasDeReproduccionController.crearListaDeReproduccion(cancionesLista,listaDeReproduccionCreada);
                playerActivity.putExtra("cancionesLista",cancionesLista);
                startActivity(playerActivity);
            }
        });

    }

    private void abrirActivity(Class activityNueva) {
        Intent intent = new Intent(this, activityNueva);
        String message = "Bingo";
        intent.putExtra("datos", message);
        startActivity(intent);
    }

    public void refreshList() {
        if (adaptadorListaExplorarCanciones != null) {
            adaptadorListaExplorarCanciones.notifyDataSetChanged();
        }
    }
}