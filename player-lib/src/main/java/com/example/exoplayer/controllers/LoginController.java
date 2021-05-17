package com.example.exoplayer.controllers;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.exoplayer.LoginActivity;
import com.example.exoplayer.models.Usuario;
import com.example.exoplayer.requests.RequestManager;
import com.example.exoplayer.requests.UsuarioRequest;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginController {

    public LoginController(){


    }

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
}
