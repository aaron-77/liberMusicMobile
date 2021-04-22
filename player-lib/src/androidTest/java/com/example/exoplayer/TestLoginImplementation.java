package com.example.exoplayer;

import android.app.Activity;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import androidx.test.rule.ActivityTestRule;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.exoplayer.requests.RequestManager;
import com.example.exoplayer.requests.UsuarioRequest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@SmallTest
public class TestLoginImplementation {

    @Rule
    public  ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule(LoginActivity.class,true,true);

    @Test
    public void loginCorrecto(){

      Response.Listener<Usuario> listener = new Response.Listener<Usuario>() {
          @Override
          public void onResponse(Usuario response) {
              assertEquals("marcos99",response.getNombreDeUsuario());
          }
      };

      Response.ErrorListener errorListener = new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
                String algo = "algo";
          }
      };


        LoginActivity activity = activityRule.getActivity();

        RequestQueue queue = Volley.newRequestQueue(activity);
        UsuarioRequest request = RequestManager.crearUserRequest("http://192.160.100.17:8090/Suscripcion/RegistrarUsuario",listener,errorListener);
        queue.add(request);

    }




}
