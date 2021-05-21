package com.example.exoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exoplayer.R;
import com.example.exoplayer.models.Cancion;

import java.util.ArrayList;

public class AdaptadorListaMenuCuenta extends BaseAdapter {
    private Context contexto;
    private int idLista;
    private ArrayList<String> contenido;
    public AdaptadorListaMenuCuenta(Context contexto){
        this.contexto = contexto;
    }


    public AdaptadorListaMenuCuenta(Context contexto, int idLista , ArrayList<String> contenido){
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
        listaConDatos= layoutInflater.inflate(R.layout.layout_lista_menu_cuenta, null);
        // Valor actual según la posición
        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textOpcionMenu = (TextView) listaConDatos.findViewById(R.id.texto_nombre_menu);
        ImageView imagen = (ImageView) listaConDatos.findViewById(R.id.icono_menu);
        if(contenido.get(position).equals("cerrar sesion")){
            imagen.setImageResource(R.drawable.ic_baseline_login_24);
        }
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
