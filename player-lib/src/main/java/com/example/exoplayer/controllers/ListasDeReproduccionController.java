package com.example.exoplayer.controllers;

import android.provider.MediaStore;

import com.example.exoplayer.models.Cancion;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.MimeTypes;

import java.util.ArrayList;

public class ListasDeReproduccionController {


    public ListasDeReproduccionController() {
    }


    private static ArrayList<MediaItem> agregarCancionAPlayList(Cancion cancion, ArrayList<MediaItem>listaDeReproduccion){
        if(cancion != null && listaDeReproduccion != null){
            MediaItem mediaItem = new MediaItem.Builder()
                    .setUri(cancion.getUrlDeCancion())
                    .setMimeType(MimeTypes.APPLICATION_MPD)
                    .build();
            listaDeReproduccion.add(mediaItem);
        }

        return listaDeReproduccion;
    }

    public static ArrayList<MediaItem> crearListaDeReproduccion(ArrayList<Cancion>cancionesParaPLayList,ArrayList<MediaItem>playList){
        for(Cancion cancion : cancionesParaPLayList){
            agregarCancionAPlayList(cancion,playList);
        }
        return playList;
    }
}
