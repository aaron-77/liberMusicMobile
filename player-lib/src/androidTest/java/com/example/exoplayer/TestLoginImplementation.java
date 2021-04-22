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
import com.example.exoplayer.controllers.LoginController;
import com.example.exoplayer.models.Usuario;
import com.example.exoplayer.requests.RequestManager;
import com.example.exoplayer.requests.UsuarioRequest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@SmallTest
@RunWith(MockitoJUnitRunner.class)
public class TestLoginImplementation {

    @Rule
    public  ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule(LoginActivity.class,true,true);
    @Mock
    LoginController loginController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }
    @Test
    public void loginCorrecto(){


        LoginActivity activity = activityRule.getActivity();
        onView(withId(R.id.user_edit))
                .perform(typeText("marcos99"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.password_edit))
                .perform(typeText("Administrador99"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());




    }




}
