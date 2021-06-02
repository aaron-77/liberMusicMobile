package com.example.exoplayer.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaDeReproduccion implements Serializable {
    private String idLista;
    private String nombreista;
    private ArrayList<Cancion> cancionesPlaylist;

    public ListaDeReproduccion() {
        this.idLista = "vacio";
        this.nombreista = "vacio";
        this.cancionesPlaylist = new ArrayList<Cancion>();
    }

    public String getIdLista() {
        return idLista;
    }

    public void setIdLista(String idLista) {
        this.idLista = idLista;
    }

    public String getNombreista() {
        return nombreista;
    }

    public void setNombreista(String nombreista) {
        this.nombreista = nombreista;
    }

    public ArrayList<Cancion> getCancionesPlaylist() {
        return cancionesPlaylist;
    }

    public void setCancionesPlaylist(ArrayList<Cancion> cancionesPlaylist) {
        this.cancionesPlaylist = cancionesPlaylist;
    }
}
