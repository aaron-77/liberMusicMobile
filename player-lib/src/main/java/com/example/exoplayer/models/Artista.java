package com.example.exoplayer.models;

public class Artista {

    private String id;
    private String nombre;
    private String nombreArtistico;
    private int anoDeNacimiento;
    private String web;
    private String nacionalidad;
    private String fkIdEstatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public int getAnoDeNacimiento() {
        return anoDeNacimiento;
    }

    public void setAnoDeNacimiento(int anoDeNacimiento) {
        this.anoDeNacimiento = anoDeNacimiento;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFkIdEstatus() {
        return fkIdEstatus;
    }

    public void setFkIdEstatus(String fkIdEstatus) {
        this.fkIdEstatus = fkIdEstatus;
    }
}
