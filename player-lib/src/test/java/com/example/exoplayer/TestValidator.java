package com.example.exoplayer;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.exoplayer.models.Usuario;
import com.example.exoplayer.requests.RequestManager;
import com.example.exoplayer.requests.UsuarioRequest;
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
    @Test
    public void testLoginCorrecto(){
        String url = "http://192.168.100.17:8090/suscripcion/Login";
        final Usuario[] usuarioLogeado = new Usuario[1];
        Response.Listener<Usuario> responseListener = new Response.Listener<Usuario>(){
            @Override
            public void onResponse(Usuario response) {
                usuarioLogeado[0] = response;
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", "Fallo la peticion");
            }
        };
        RequestQueue queue = Volley.newRequestQueue(new LoginActivity());
        UsuarioRequest<Usuario> request = RequestManager.crearUserRequest(url,responseListener,errorListener);
        queue.add(request);
    }
}
