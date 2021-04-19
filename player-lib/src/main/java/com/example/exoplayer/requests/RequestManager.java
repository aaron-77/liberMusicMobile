package com.example.exoplayer.requests;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.exoplayer.Usuario;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RequestManager {


    public static UsuarioRequest<Usuario> crearUserRequest(String url,Response.Listener<Usuario> responseListener,Response.ErrorListener errorListener) {

       HashMap<String,String> headers = RequestManager.crearHeaders();
       UsuarioRequest<Usuario> request = new UsuarioRequest(url, Usuario.class, headers, responseListener, errorListener);
        return request;
    }
    private static HashMap<String,String>crearHeaders(){

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Content-Length","");
        headers.put("Host","");
        headers.put("Accept","*/*");
        headers.put("Accept-Encoding","gzip,deflate,br");
        headers.put("Connection","keep-alive");
        return headers;
    }


}
