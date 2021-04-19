package com.example.exoplayer.controllers;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.exoplayer.LoginActivity;
import com.example.exoplayer.Usuario;
import com.example.exoplayer.requests.RequestManager;
import com.example.exoplayer.requests.UsuarioRequest;

public class LoginController {

    public LoginController(){


    }

    public Usuario[] login(String usuario, String contrasena){
        String url = "http://192.168.100.17:8090/suscripcion/Login";
        final Usuario[] usuarioLogeado = new Usuario[1];
        Response.Listener<Usuario> responseListener = new Response.Listener<Usuario>(){
            @Override
            public void onResponse(Usuario response) {
                usuarioLogeado[0] = response;
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", "Fallo la peticion");
            }
        };
        RequestQueue queue = Volley.newRequestQueue(new LoginActivity());
        UsuarioRequest<Usuario> request = RequestManager.crearUserRequest(url,responseListener,errorListener);
        queue.add(request);
        return usuarioLogeado;
    }
}
