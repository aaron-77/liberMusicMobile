package com.example.exoplayer.requests;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.example.exoplayer.models.Usuario;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class UsuarioRequest<Usuario> extends Request<Usuario> {
    private final Gson gson = new Gson();
    private final Class<Usuario> clazz;
    private final Map<String, String> headers;
    private final Response.Listener<Usuario> listener;

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url URL of the request to make
     * @param clazz Relevant class object, for Gson's reflection
     * @param headers Map of request headers
     */
    public UsuarioRequest(String url, Class<Usuario> clazz, Map<String, String> headers,
                       Response.Listener<Usuario> listener, Response.ErrorListener errorListener) {

        super(Request.Method.GET, url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(Usuario response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<Usuario> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}
