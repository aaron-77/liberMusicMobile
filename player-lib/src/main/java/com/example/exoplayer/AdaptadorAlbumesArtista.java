package com.example.exoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exoplayer.models.Cancion;

import java.util.ArrayList;

public class AdaptadorAlbumesArtista extends BaseAdapter {
    private Context contexto;
    private int idLista;
    private ArrayList<Cancion> contenido;
    public AdaptadorAlbumesArtista(Context contexto){
        this.contexto = contexto;
    }


    public AdaptadorAlbumesArtista(Context contexto, int idLista , ArrayList<Cancion> contenido){
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
        listaConDatos= layoutInflater.inflate(R.layout.layout_lista_albumes_artista, null);
        // Valor actual según la posición
        String tituloAlbum = contenido.get(position).getNombreAlbum();
        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textTituloAlbum = (TextView) listaConDatos.findViewById(R.id.texto_titulo_album);
        ImageView portada = (ImageView) listaConDatos.findViewById(R.id.imagenAlbum);
        textTituloAlbum.setText(tituloAlbum);
        //String url ="https://github.com/aaron-77/LiberMusicMobile/blob/main/imageramas.png";
        /*
        RequestOptions requestOptions = new RequestOptions().override(200,200);
            Glide.with(contexto)
                .load(rutaImagen)
                .apply(requestOptions)
                .into(portada);
        */
        return listaConDatos;
    }

}
