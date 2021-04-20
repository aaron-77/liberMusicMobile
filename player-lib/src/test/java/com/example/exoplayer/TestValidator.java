package com.example.exoplayer;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.exoplayer.controllers.LoginController;
import com.example.exoplayer.requests.RequestManager;
import com.example.exoplayer.requests.UsuarioRequest;
import com.example.exoplayer.utilities.Validator;

import org.junit.Test;

import java.io.File;
import java.lang.ref.ReferenceQueue;

import static org.junit.Assert.*;

public class TestValidator {
    @Test
    public void validarUrlImagenCorecta(){
       String url = "http://host/multimedia/artistas/12345-12345-12345-12345-12345-123456/albumes/12345-12345-12345-12345-12345-123456/portadas/imagen.jpg";
       boolean resultadoValidacion = Validator.validarTexto(url,Validator.REGEX_URL_IMAGEN);
       assertTrue(resultadoValidacion);
    }
    @Test
    public void validarUrlImagenIncorrecta(){
        String url = "http://host/multimedia/12345-12345-12345-12345-12345-123456/albumes/12345-12345-12345-12345-12345-123456/portadas/imagen.jpg";
        boolean resultadoValidacion = Validator.validarTexto(url,Validator.REGEX_URL_IMAGEN);
        assertFalse(resultadoValidacion);
    }
    @Test
    public void validarDatoNUmericoCorrecto(){
        int numero = 1999;
        boolean resultadoValidacion = Validator.validarValorNumericoEntero(numero);
        assertTrue(resultadoValidacion);
    }
    @Test
    public void validarDatoNumericoIncorrecto(){
        int numero = -1999;
        boolean resultadoValidacion = Validator.validarValorNumericoEntero(numero);
        assertFalse(resultadoValidacion);
    }
}
