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
        contenido.add("Compañera");
        contenido.add("usted sabe");
        contenido.add("que puede contar");
        contenido.add("conmigo");
        contenido.add("no hasta dos");
        contenido.add("o hasta diez");
        contenido.add("sino contar");
        contenido.add("conmigo");
        contenido.add("si alguna vez");
        contenido.add("advierte");
        contenido.add("que la miro a los ojos");
        contenido.add("y una veta de amor");
        contenido.add("reconoce en los míos");
        contenido.add("no alerte sus fusiles");
        contenido.add("ni piense qué delirio");
        contenido.add("a pesar de la veta");
        contenido.add("o tal vez porque existe");
        contenido.add("usted puede contar");
        contenido.add("conmigo");
        contenido.add("si otras veces");
        contenido.add("me encuentra");
        contenido.add("huraño sin motivo");
        contenido.add("no piense qué flojera");
        contenido.add("igual puede contar");
        contenido.add("conmigo");
        contenido.add("pero hagamos un trato");
        contenido.add("yo quisiera contar");
        contenido.add("con usted");
        contenido.add("es tan lindo");
        contenido.add("saber que usted existe");
        contenido.add("uno se siente vivo");
        contenido.add("y cuando digo esto");
        contenido.add("quiero decir contar");
        contenido.add("aunque sea hasta dos");
        contenido.add("aunque sea hasta cinco");
        contenido.add("no ya para que acuda");
        contenido.add("presurosa en mi auxilio");
        contenido.add("sino para saber");
        contenido.add("a ciencia cierta");
        contenido.add("que usted sabe que puede");
        contenido.add("contar conmigo.");
        //ArrayAdapter<String>adaptadorConContenido = new ArrayAdapter<String>(this,R.id.list_results_search,contenido);

        lista.setAdapter(new AdaptadorListaBuscador(contexto, R.id.layout_list_results, contenido));
    }
}