package com.example.exoplayer.utilities;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.nio.charset.StandardCharsets;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class Cifrador {


    public Cifrador() {

    }

    public static String cifrarSha256(String cadenaParaCifrar){
        byte[] bytesDeCadenaParaCifrar = cadenaParaCifrar.getBytes();
        String cadenaCifrada = new String(bytesDeCadenaParaCifrar, StandardCharsets.UTF_8);

        return cadenaCifrada;
    }

}
