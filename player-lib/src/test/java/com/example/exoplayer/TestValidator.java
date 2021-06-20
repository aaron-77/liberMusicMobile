package com.example.exoplayer;

import com.example.exoplayer.utilities.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
@RunWith(MockitoJUnitRunner.class)
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
