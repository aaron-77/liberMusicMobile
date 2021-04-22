package com.example.exoplayer.models;

public class DatosDeLocalizacion {

    private String Email;
    private String Pais;
    private String FKIdusuario;

    public DatosDeLocalizacion(String email, String pais, String FKIdusuario) {
        Email = email;
        Pais = pais;
        this.FKIdusuario = FKIdusuario;
    }

    public DatosDeLocalizacion() {

    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getFKIdusuario() {
        return FKIdusuario;
    }

    public void setFKIdusuario(String FKIdusuario) {
        this.FKIdusuario = FKIdusuario;
    }
}
