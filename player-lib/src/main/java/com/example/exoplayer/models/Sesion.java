package com.example.exoplayer.models;

public class Sesion {
    private Usuario usuario ;
    private Artista artista;


    public Sesion(Usuario usuario, Artista artista) {
        this.usuario = usuario;
        this.artista = artista;
    }

    public Sesion() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }


}
