package com.example.exoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exoplayer.models.Cancion;
import com.example.exoplayer.models.ListaDeReproduccion;

import java.util.ArrayList;

public class AdaptadorListasDeRerpoduccionDetail extends BaseAdapter {
    private Context contexto;
    private int idLista;
    private ArrayList<Cancion> contenido;
    public AdaptadorListasDeRerpoduccionDetail(Context contexto){
        this.contexto = contexto;
    }


    public AdaptadorListasDeRerpoduccionDetail(Context contexto, int idLista , ArrayList<Cancion> contenido){
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
        listaConDatos= layoutInflater.inflate(R.layout.layout_canciones_lista_de_reproduccion, null);
        // Valor actual según la posición
        String tituloCancion = contenido.get(position).getTituloCancion();
        String duracion = String.valueOf(contenido.get(position).getDuracion());
        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textTituloCancion = (TextView) listaConDatos.findViewById(R.id.texto_nombre_cancion);
        TextView textDuracion =(TextView) listaConDatos.findViewById(R.id.texto_duracion) ;
        ImageView portada = (ImageView) listaConDatos.findViewById(R.id.imagenCancion);
        textTituloCancion.setText(tituloCancion);
        textDuracion.setText(duracion);
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
