package com.example.exoplayer.utilities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.exoplayer.PlayerActivity;
import com.example.exoplayer.R;
import com.example.exoplayer.models.Cancion;

import java.util.ArrayList;

public class ElementoReproducible extends LinearLayout {

    public ImageView _fotoElemento;
    public TextView _nombreElemento;
    public TextView _complemento;
    private ArrayList<Cancion> elementos;

    public ElementoReproducible(String fotoUri, String nombreElemento, ArrayList<Cancion> objeto, @NonNull Context context) {
        super(context);
        elementos = objeto;

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.elementoreproducible_design, this, true);

        _fotoElemento = (ImageView) findViewById(R.id.img_fotoElemento);
        _nombreElemento = (TextView) findViewById(R.id.text_nombreElemento);

    }

    public void clicReproducir(View v)
    {
        Intent direccion = new Intent(getContext(), PlayerActivity.class);
        direccion.putExtra("lista", elementos);
        //startActivity(direccion);
    }
}
