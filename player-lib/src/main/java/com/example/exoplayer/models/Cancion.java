package com.example.exoplayer.models;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.exoplayer.HomeActivity;
import com.example.exoplayer.requests.ManagerRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Cancion implements Serializable {

    private String idCancion;
    private String fkIdAlbum;
    private String nombreAlbum;
    private String idArtista;
    private String nombreArtista;
    private String urlPortada;
    private String tituloCancion;
    private int duracion;
    private int numeroDeTrack;
    private String urlDeCancion;

    public Cancion() {
    }

    public Cancion(String idCancion, String tituloCancion, int duracion, int numeroDeTrack) {
        this.idCancion = idCancion;
        this.tituloCancion = tituloCancion;
        this.duracion = duracion;
        this.numeroDeTrack = numeroDeTrack;
    }

    public Cancion(String idCancion, String fkIdAlbum, String nombreAlbum, String tituloCancion, int duracion, int numeroDeTrack) {
        this.idCancion = idCancion;
        this.fkIdAlbum = fkIdAlbum;
        this.nombreAlbum = nombreAlbum;
        this.tituloCancion = tituloCancion;
        this.duracion = duracion;
        this.numeroDeTrack = numeroDeTrack;
    }

    public Cancion(String idCancion, String fkIdAlbum, String nombreAlbum, String idArtista, String nombreArtista, String tituloCancion, int duracion, int numeroDeTrack) {
        this.idCancion = idCancion;
        this.fkIdAlbum = fkIdAlbum;
        this.nombreAlbum = nombreAlbum;
        this.idArtista = idArtista;
        this.nombreArtista = nombreArtista;
        this.tituloCancion = tituloCancion;
        this.duracion = duracion;
        this.numeroDeTrack = numeroDeTrack;
    }

    public Cancion(String idCancion, String fkIdAlbum, String nombreAlbum, String idArtista, String nombreArtista, String urlPortada, String tituloCancion, int duracion, int numeroDeTrack, String urlDeCancion) {
        this.idCancion = idCancion;
        this.fkIdAlbum = fkIdAlbum;
        this.nombreAlbum = nombreAlbum;
        this.idArtista = idArtista;
        this.nombreArtista = nombreArtista;
        this.urlPortada = urlPortada;
        this.tituloCancion = tituloCancion;
        this.duracion = duracion;
        this.numeroDeTrack = numeroDeTrack;
        this.urlDeCancion = urlDeCancion;
    }

    public String getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(String idCancion) {
        this.idCancion = idCancion;
    }

    public String getFkIdAlbum() {
        return fkIdAlbum;
    }

    public void setFkIdAlbum(String fkIdAlbum) {
        this.fkIdAlbum = fkIdAlbum;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNumeroDeTrack() {
        return numeroDeTrack;
    }

    public void setNumeroDeTrack(int numeroDeTrack) {
        this.numeroDeTrack = numeroDeTrack;
    }

    public String getUrlDeCancion() {
        return urlDeCancion;
    }

    public void setUrlDeCancion(String urlDeCancion) {
        this.urlDeCancion = urlDeCancion;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(String idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }
    public static  void explorarCanciones(final ManagerRequest.QueueObject queque,
                                          final ArrayList<Cancion> canciones,
                                          final HomeActivity _interface){

        String url = "http://192.168.100.2:4001/canciones/buscar?todas=true";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.has("datos")) {

                            try {
                                JSONArray list = response.getJSONArray("datos");
                                for (int i=0; i < list.length(); i++) {
                                    JSONObject o = list.getJSONObject(i);

                                    Cancion cancion = new Cancion();
                                    cancion.setTituloCancion(o.getString("id"));
                                    cancion.setTituloCancion(o.getString("titulo"));
                                    cancion.setDuracion(o.getInt("duracion"));
                                    cancion.setNumeroDeTrack(o.getInt("numeroDeTrack"));
                                    if(o.getString("titulo").equals("the killing hand")){
                                            cancion.urlDeCancion = "http://192.168.100.2:4002/streaming/artistas/dreamtheater/whendreamanddayunite/dash/index.mpd";
                                    }
                                    canciones.add(cancion);
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            _interface.refreshList(); // Esta función debemos implementarla
                            // en nuestro activity
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queque.addToRequestQueue(jsonObjectRequest);

    }
}
