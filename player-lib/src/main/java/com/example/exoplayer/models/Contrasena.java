package com.example.exoplayer.models;

public class Contrasena {
    private String Contrasena1;
    private String  FKIdusuario;

    public Contrasena(String contrasena1, String FKIdusuario) {
        Contrasena1 = contrasena1;
        this.FKIdusuario = FKIdusuario;
    }

    public Contrasena() {

    }

    public String getContrasena1() {
        return Contrasena1;
    }

    public void setContrasena1(String contrasena1) {
        Contrasena1 = contrasena1;
    }

    public String getFKIdusuario() {
        return FKIdusuario;
    }

    public void setFKIdusuario(String FKIdusuario) {
        this.FKIdusuario = FKIdusuario;
    }
}
