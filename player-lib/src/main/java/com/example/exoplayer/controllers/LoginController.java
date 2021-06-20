package com.example.exoplayer.controllers;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.exoplayer.LoginActivity;
import com.example.exoplayer.R;
import com.example.exoplayer.config.ConfigUsuarios;
import com.example.exoplayer.models.Usuario;
import com.example.exoplayer.requests.RequestManager;
import com.example.exoplayer.requests.UsuarioRequest;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    public LoginController(){


    }

    /*
    public Usuario[] login(String usuario, String contrasena, Context contexto){
        URL urltype ;
        Uri urlBuilt;
        String urlBase = "http://192.168.100.2:8090/suscripcion/login";
        urlBuilt = Uri.parse(urlBase+"?").buildUpon()
                .appendQueryParameter("nombreDeUsuario",usuario)
                .appendQueryParameter("contrasena",contrasena)
                .build();
        try {
            urltype = new URL(urlBuilt.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        RequestManager.crearUserRequest(urlBuilt.toString(),contexto);
        return new Usuario[1];
    }
    */
    public void crearPeticionPost(String user, String pass, Context contexto,JSONObject body){
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

           // String url = "http://192.168.100.2:8090/suscripcion/Login";
            String url = ConfigUsuarios.URL_LOGIN;

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.POST, urlBuilt.toString(), body, new Response.Listener<JSONObject>() {

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
                    }) ;

            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(15000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
// Access the RequestQueue through your singleton class.
            queue.add(jsonObjectRequest);
        }catch(Exception ex){
            String paraenlinea="";
        }
    }

}
