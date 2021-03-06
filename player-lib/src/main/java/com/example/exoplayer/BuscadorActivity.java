package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BuscadorActivity extends AppCompatActivity {

    //tercer comentario de prueba para lint 
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public Context contexto;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(PlayerActivity.EXTRA_MESSAGE);
        contexto = this;

        // Capture the layout's TextView and set the string as its text
        TextInputEditText textView = findViewById(R.id.buscador_edit);
        textView.setText(message);
        //insertarLista(this);
        crearPeticion();
    }


    private void insertarLista(Context contexto,ArrayList respuesta) {
        ListView lista = (ListView) findViewById(R.id.listview_resultados_listas);
        lista.setAdapter(new AdaptadorListaBuscador(contexto, R.id.layout_listas_results, respuesta));
    }

    private void crearPeticion(){

        RequestQueue queue = Volley.newRequestQueue(this);
        URL urltype ;
        Uri urlBuilt;
        String urlBase = "http://gateway.marvel.com/v1/public/characters";
        urlBuilt = Uri.parse(urlBase+"?").buildUpon()
                .appendQueryParameter("name","thor")
                .appendQueryParameter("apikey","231d8e6a04eb7446a1f395b460ff5b00")
                .appendQueryParameter("ts","2")
                .appendQueryParameter("hash","33be76f1ce01631d6d70b4d3a30eb245")
                .build();
        try {
            urltype = new URL(urlBuilt.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String url = "https://gateway.marvel.com/v1/public/characters?ts=2&apikey=231d8e6a04eb7446a1f395b460ff5b00&hash=33BE76F1CE01631D6D70B4D3A30EB245&name=thor";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, urlBuilt.toString(), null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                            insertarLista(contexto,new ArrayList());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyError  errorsote= error;
                    }
                });


        queue.add(jsonObjectRequest);
    }
}
