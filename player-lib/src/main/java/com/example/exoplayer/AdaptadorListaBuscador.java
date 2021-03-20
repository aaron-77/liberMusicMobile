package com.example.exoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorListaBuscador extends BaseAdapter {

    private Context contexto;
    private int idLista;
    private ArrayList<String> contenido;
    public AdaptadorListaBuscador(Context contexto){
        this.contexto = contexto;
    }


    public AdaptadorListaBuscador(Context contexto, int idLista , ArrayList<String> contenido){
        this.contexto = contexto;
        this.idLista = idLista;
        this.contenido = contenido;

    }
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return new Object();
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Copiamos la vista
        View listaConDatos = convertView;
        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.contexto);
        listaConDatos= layoutInflater.inflate(R.layout.layout_lista_resultados_busqueda, null);
        // Valor actual según la posición
        String texto  = this.contenido.get(position);
        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) listaConDatos.findViewById(R.id.texto_resultado);
        textView.setText(texto);
        ImageView imagen = (ImageView) listaConDatos.findViewById(R.id.imagen);
        String url ="https://github.com/aaron-77/LiberMusicMobile/blob/main/imageramas.png";
        RequestOptions requestOptions = new RequestOptions().override(200,200);
            Glide.with(contexto)
                .load(url)
                .apply(requestOptions)
                .into(imagen);

        return listaConDatos;
    }
}
