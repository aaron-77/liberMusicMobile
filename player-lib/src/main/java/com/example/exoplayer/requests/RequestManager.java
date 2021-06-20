package com.example.exoplayer.requests;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.exoplayer.models.Usuario;

import java.util.HashMap;

public class RequestManager {


    public static void crearUserRequest(String url, Context contexto) {
        RequestQueue queue = Volley.newRequestQueue(contexto);
        HashMap<String,String> headers = RequestManager.crearHeaders();
       UsuarioRequest<Usuario> request = new UsuarioRequest(url, Usuario.class, headers, new Response.Listener<Usuario>(){
           @Override
           public void onResponse(Usuario response) {
                String val = "";

           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

               Log.d("error", "Fallo la peticion");
           }
       });

        request.setRetryPolicy(new DefaultRetryPolicy(15000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(request);

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
