package com.example.exoplayer;

public class Usuario {
    private String Id;
    private String NombreDeUsuario;
    private String NombreDelPropietario;
    private String Contrasena;
    private int FkIdEstatus;

    public Usuario(String nombreDeUsuarioP,String contrasenaP,String nombreDelPropietario){
        this.Id = "";
        this.NombreDeUsuario= nombreDeUsuarioP;
        this.Contrasena = contrasenaP;
        this.NombreDelPropietario = nombreDelPropietario;
        this.FkIdEstatus = 1;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.NombreDeUsuario = nombreDeUsuario;
    }

    public void setContrasena(String contrasena) {
        this.Contrasena = contrasena;
    }

    public void setNombreDelPropietario(String nombreDelPropietario){
        this.NombreDelPropietario = nombreDelPropietario;
    }

    public void setFkIdEstatus(int fkIdEstatus) {
        FkIdEstatus = fkIdEstatus;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombreDelPropietario(){
        return this.NombreDelPropietario;
    }

    public String getId() {
        return Id;
    }
    public int getFkIdEstatus(){
        return this.FkIdEstatus;
    }
    public String getNombreDeUsuario() {
        return NombreDeUsuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

}
