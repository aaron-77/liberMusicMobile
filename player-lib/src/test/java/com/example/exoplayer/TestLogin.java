package com.example.exoplayer;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.exoplayer.controllers.LoginController;
import com.example.exoplayer.requests.RequestManager;
import com.example.exoplayer.requests.UsuarioRequest;

import org.junit.Test;

import java.lang.ref.ReferenceQueue;

import static org.junit.Assert.*;

public class TestLogin {
    @Test
    public void loginCorrecto(){
        LoginController loginController = new LoginController();
        Usuario[] usuarioLogin = loginController.login("marcos99","Administrador99");
        assertEquals("marcos99",usuarioLogin[0].getNombreDeUsuario());

    }
}
