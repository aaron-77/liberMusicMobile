package com.example.exoplayer.models;
//comentario de prueba 2
public class Usuario {

    private String Id;
    private String FkIdArtista;
    private String NombreDeUsuario;
    private String NombreDeLPropietario;
    private int FkIdEstatus;
    private Contrasena Contrasena;
    private DatosDeLocalizacion DatosDeLocalizacion;

    public Usuario(String id, String fkIdArtista, String nombreDeUsuario, String nombreDeLPropietario, int fkIdEstatus, Contrasena contrasena, DatosDeLocalizacion datosDeLocalizacion) {
        Id = id;
        FkIdArtista = fkIdArtista;
        NombreDeUsuario = nombreDeUsuario;
        NombreDeLPropietario = nombreDeLPropietario;
        FkIdEstatus = fkIdEstatus;
        Contrasena = contrasena;
        DatosDeLocalizacion = datosDeLocalizacion;
    }


    public Usuario(String id, String fkIdArtista, String nombreDeUsuario) {
        Id = id;
        FkIdArtista = fkIdArtista;
        NombreDeUsuario = nombreDeUsuario;
        NombreDeLPropietario = "";
        FkIdEstatus =1;
        Contrasena = null;
        DatosDeLocalizacion = null;
    }

    public Usuario() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFkIdArtista() {
        return FkIdArtista;
    }

    public void setFkIdArtista(String fkIdArtista) {
        FkIdArtista = fkIdArtista;
    }

    public String getNombreDeUsuario() {
        return NombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        NombreDeUsuario = nombreDeUsuario;
    }

    public String getNombreDeLPropietario() {
        return NombreDeLPropietario;
    }

    public void setNombreDeLPropietario(String nombreDeLPropietario) {
        NombreDeLPropietario = nombreDeLPropietario;
    }

    public int getFkIdEstatus() {
        return FkIdEstatus;
    }

    public void setFkIdEstatus(int fkIdEstatus) {
        FkIdEstatus = fkIdEstatus;
    }

    public Contrasena getContrasena() {
        return Contrasena;
    }

    public void setContrasena(Contrasena contrasena) {
        this.Contrasena = contrasena;
    }

    public DatosDeLocalizacion getDatosDeLocalizacion() {
        return DatosDeLocalizacion;
    }

    public void setDatosDeLocalizacion(DatosDeLocalizacion datosDeLocalizacion) {
        this.DatosDeLocalizacion = datosDeLocalizacion;
    }
}
