package com.example.exoplayer.controllers;

import android.content.Context;
import android.net.Uri;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.exoplayer.LoginActivity;
import com.example.exoplayer.R;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class SubscripcionController {

    private void crearPeticion(String user, String pass, Context contexto){
        URL urltype ;
        Uri urlBuilt;
        String urlBase = "http://192.168.100.2:8090/suscripcion/login";
        urlBuilt = Uri.parse(urlBase+"?").buildUpon()
                .appendQueryParameter("nombreDeUsuario",user)
                .appendQueryParameter("contrasena",pass)
                .build();
        try {
            urltype = new URL(urlBuilt.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try{
            RequestQueue queue = Volley.newRequestQueue(contexto);

            String url = "http://192.168.100.2:8090/suscripcion/Login";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, urlBuilt.toString(), null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            LoginActivity activity = (LoginActivity)contexto;
                            EditText useredit = (EditText) activity.findViewById(R.id.user_edit);
                            try{
                                String nombreDeUsuarioResponse = response.getString("nombreDeUsuario");
                                if(nombreDeUsuarioResponse.equals(useredit.getText().toString())){
                                    //abrirActivity();
                                }
                            }catch(Exception ex){

                            }

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            VolleyError  errorsote= error;
                        }
                    });

            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(15000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
// Access the RequestQueue through your singleton class.
            queue.add(jsonObjectRequest);
        }catch(Exception ex){
            String paraenlinea="";
        }
    }
}
