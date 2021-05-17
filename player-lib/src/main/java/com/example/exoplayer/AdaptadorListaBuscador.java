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
import com.example.exoplayer.models.Cancion;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorListaBuscador extends BaseAdapter {

    private Context contexto;
    private int idLista;
    private ArrayList<Cancion> contenido;
    public AdaptadorListaBuscador(Context contexto){
        this.contexto = contexto;
    }


    public AdaptadorListaBuscador(Context contexto, int idLista , ArrayList<Cancion> contenido){
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
        listaConDatos= layoutInflater.inflate(R.layout.layout_lista_resultados_busqueda, null);
        // Valor actual según la posición
        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textNombreCancion = (TextView) listaConDatos.findViewById(R.id.texto_nombre_cancion);
        TextView textDuracion = (TextView) listaConDatos.findViewById(R.id.texto_nombre_album);
        TextView textNumeroDeTrack = (TextView) listaConDatos.findViewById(R.id.texto_nombre_artista);
        ImageView imagen = (ImageView) listaConDatos.findViewById(R.id.imagen);
        String tituloCancion = contenido.get(position).getTituloCancion();
        String duracion = String.valueOf(contenido.get(position).getDuracion()/60);
        String numeroDeTrack =String.valueOf( contenido.get(position).getNumeroDeTrack());
        String rutaImagen = contenido.get(position).getUrlPortada();
        textNombreCancion.setText(tituloCancion);
        textDuracion.setText(duracion);
        textNumeroDeTrack.setText(numeroDeTrack);
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
