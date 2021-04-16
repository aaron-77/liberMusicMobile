package com.example.exoplayer;

public class Usuario {
    private String nombreDeUsuario;
    private String contrasena;
    public Usuario(String nombreDeUsuarioP,String contrasenaP){
        this.nombreDeUsuario= nombreDeUsuarioP;
        this.contrasena = contrasenaP;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }
}
