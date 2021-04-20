package com.example.exoplayer.models;

public class Cancion {

    private String idCancion;
    private String fkIdAlbum;
    private String urlPortada;
    private String tituloCancion;
    private int duracion;
    private int numeroDeTrack;
    private String urlDeCancion;

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


}
