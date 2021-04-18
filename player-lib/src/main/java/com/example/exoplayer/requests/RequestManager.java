package com.example.exoplayer.requests;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.exoplayer.Usuario;

import org.json.JSONObject;

public class RequestManager {

    /**
    public static UsuarioRequest crearUserRequest(String url) {

        final Usuario usuarioResponse;
        UsuarioRequest<Usuario> request = new UsuarioRequest
                (url, Usuario.class, Map<String,String > headers, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        usuarioResponse = response;
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyError errorsote = error;
                    }
                });
        return null;
    }
      **/
}
