package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ArtistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artista);


        //Crear ElementoReproducible para cada album y
        //agregar elementos a espacioLista
        //
        //
    }


    public void clicRegreso(View view)
    {
        Intent regreso = new Intent(this, HomeActivity.class);
        startActivity(regreso);
    }

    public void clicReproducir (View view)
    {
         Intent reproduccion = new Intent(this, PlayerActivity.class);
        startActivity(reproduccion);
    }
}