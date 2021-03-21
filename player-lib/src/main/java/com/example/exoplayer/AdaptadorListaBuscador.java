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

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorListaBuscador extends BaseAdapter {

    private Context contexto;
    private int idLista;
    private JSONObject contenido;
    public AdaptadorListaBuscador(Context contexto){
        this.contexto = contexto;
    }


    public AdaptadorListaBuscador(Context contexto, int idLista , JSONObject contenido){
        this.contexto = contexto;
        this.idLista = idLista;
        this.contenido = contenido;

    }
    @Override
    public int getCount() {
        int elementos = 0;
        try {
            elementos = ((JSONObject) contenido.get("data"))
                    .getJSONArray("results").length();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return elementos;
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
        TextView textView = (TextView) listaConDatos.findViewById(R.id.texto_resultado);
        TextView descripcionHeroe = (TextView) listaConDatos.findViewById(R.id.texto_descripcion);
        TextView textoCopyRight = (TextView) listaConDatos.findViewById(R.id.texto_copyright);
        ImageView imagen = (ImageView) listaConDatos.findViewById(R.id.imagen);
        String datosCopyRight = "";
        JSONObject datosDelSuperHeroe = null;
        String nombre = "";
        String descripcion = "";
        String rutaImagen = "";
        try {
            datosCopyRight =  contenido.getString("attributionText");
            datosDelSuperHeroe = ((JSONObject) contenido.get("data"))
                    .getJSONArray("results")
                    .getJSONObject(0);

            nombre = datosDelSuperHeroe.getString("name");
            descripcion = datosDelSuperHeroe.getString("description");
            rutaImagen = ((JSONObject)datosDelSuperHeroe.get("thumbnail"))
                    .getString("path")
                    +"."
                    +((JSONObject)datosDelSuperHeroe.get("thumbnail"))
                    .getString("extension");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        textView.setText(nombre);
        textoCopyRight.setText(datosCopyRight);
        descripcionHeroe.setText(descripcion);
        //String url ="https://github.com/aaron-77/LiberMusicMobile/blob/main/imageramas.png";
        RequestOptions requestOptions = new RequestOptions().override(200,200);
            Glide.with(contexto)
                .load(rutaImagen)
                .apply(requestOptions)
                .into(imagen);

        return listaConDatos;
    }
}
