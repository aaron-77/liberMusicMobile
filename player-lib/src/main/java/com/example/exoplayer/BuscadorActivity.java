package com.example.exoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class BuscadorActivity extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(PlayerActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextInputEditText textView = findViewById(R.id.buscador_edit);
        textView.setText(message);
        insertarLista(this);

        /*
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


         */
    }
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_buscador, container, false);
    }

 */

    private void insertarLista(Context contexto) {
        ListView lista = (ListView) findViewById(R.id.list_results_search);
        ArrayList<String> contenido = new ArrayList<String>();
        contenido.add("El destino ");
        contenido.add("es el que baraja las cartas");
        contenido.add("pero nosotros las que las jugamos");
        lista.setAdapter(new AdaptadorListaBuscador(contexto, R.id.layout_list_results, contenido));
    }
}