package com.example.exoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exoplayer.models.ListaDeReproduccion;

import java.util.ArrayList;

public class AdaptadorListaListasDeReproduccion extends BaseAdapter {

    private Context contexto;
    private int idLista;
    private ArrayList<ListaDeReproduccion> contenido;
    public AdaptadorListaListasDeReproduccion(Context contexto){
        this.contexto = contexto;
    }


    public AdaptadorListaListasDeReproduccion(Context contexto, int idLista , ArrayList<ListaDeReproduccion> contenido){
        this.contexto = contexto;
        this.idLista = idLista;
        this.contenido = contenido;
    }
    @Override
    public int getCount() {
        return contenido.size();
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
        listaConDatos= layoutInflater.inflate(R.layout.layout_lista_playlists, null);
        // Valor actual según la posición
        String nombreDeLista = contenido.get(position).getNombreista();
        // Referenciamos el elemento a modificar y lo rellenamos
        TextView nombreLista = (TextView) listaConDatos.findViewById(R.id.texto_nombre_lista);
         nombreLista.setText(nombreDeLista);
        //String url ="https://github.com/aaron-77/LiberMusicMobile/blob/main/imageramas.png";
        /*
        RequestOptions requestOptions = new RequestOptions().override(200,200);
            Glide.with(contexto)
                .load(rutaImagen)
                .apply(requestOptions)
                .into(imagen);
        */
        return listaConDatos;
    }
}
