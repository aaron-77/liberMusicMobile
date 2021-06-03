package com.example.exoplayer.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaDeReproduccion implements Serializable {
    private String idLista;
    private String nombreLista;
    private ArrayList<Cancion> cancionesPlaylist;

    public ListaDeReproduccion() {
        this.idLista = "vacio";
        this.nombreLista = "vacio";
        this.cancionesPlaylist = new ArrayList<Cancion>();
    }

    public String getIdLista() {
        return idLista;
    }

    public void setIdLista(String idLista) {
        this.idLista = idLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public ArrayList<Cancion> getCancionesPlaylist() {
        return cancionesPlaylist;
    }

    public void setCancionesPlaylist(ArrayList<Cancion> cancionesPlaylist) {
        this.cancionesPlaylist = cancionesPlaylist;
    }
}
