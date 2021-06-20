package com.example.exoplayer;

import androidx.test.filters.SmallTest;
import androidx.test.rule.ActivityTestRule;

import com.example.exoplayer.controllers.LoginController;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;


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
        onView(withId(R.id.botonSubirArchivo)).perform(click());




    }




}
