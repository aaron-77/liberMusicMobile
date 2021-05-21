package com.example.exoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.exoplayer.models.Cancion;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CuentaActivity extends AppCompatActivity {

    private BottomNavigationView barraDeNavegacion;
    AdaptadorListaMenuCuenta adaptadorListaMenuCuenta;
    ArrayList<String> opcionesMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);
        opcionesMenu = new ArrayList();
        llenarMenu();
        ListView lista = (ListView) findViewById(R.id.list_menu_cuenta);
        adaptadorListaMenuCuenta = new AdaptadorListaMenuCuenta(this, R.id.container_list_menu_cuenta, opcionesMenu);
        lista.setAdapter(adaptadorListaMenuCuenta);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(CuentaActivity.this,LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
                finish();
            }
        });
        barraDeNavegacion = findViewById(R.id.bottom_navigation);
        barraDeNavegacion.setSelectedItemId(R.id.page_5);
        barraDeNavegacion.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int idMenuItemSeleccionado=menuItem.getItemId();
                int menuPagina1= R.id.page_1;
                boolean isSelected= false;
                if (idMenuItemSeleccionado == R.id.page_1) {
                    abrirActivity(HomeActivity.class);
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
                    //no se hace nada es el activity actual
                }
                return isSelected;
            }

        });

    }
    private void abrirActivity(Class activityParaAbrir) {
        Intent intent = new Intent(this, activityParaAbrir);
        String message = "Bingo";
        intent.putExtra("datos", message);
        startActivity(intent);
    }

    private void llenarMenu(){
        opcionesMenu.add(getString(R.string.texto_item_cerrar_sesion));
    }
}