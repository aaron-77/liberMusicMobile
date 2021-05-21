/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.exoplayer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.navigation.NavController;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.exoplayer.controllers.ListasDeReproduccionController;
import com.example.exoplayer.models.Cancion;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A fullscreen activity to play audio or video streams. 
 aaaa
 */
public class PlayerActivity extends AppCompatActivity {

  private PlayerView playerView;
  private SimpleExoPlayer player;
  private boolean playWhenReady = true;
  private int currentWindow = 0;
  private long playbackPosition = 0;
  private BottomNavigationView barraDeNavegacion;
  public static final String EXTRA_MESSAGE = "el nombre mas poderoso";
  private ArrayList<Cancion> cancionesParaPlayList;
  public ArrayList<MediaItem> listaDeReproduccion;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player);
    listaDeReproduccion = new ArrayList<MediaItem>();
    playerView = findViewById(R.id.video_view);
    playerView.setUseArtwork(true);
    ImageView artWork = (ImageView)findViewById(R.id.exo_artwork);
    artWork.setImageResource(R.drawable.amarteesunplacer);
    barraDeNavegacion = findViewById(R.id.bottom_navigation);
    cancionesParaPlayList = (ArrayList<Cancion>) getIntent().getSerializableExtra("cancionesLista");
    barraDeNavegacion.setSelectedItemId(R.id.page_2);
    barraDeNavegacion.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int idMenuItemSeleccionado=menuItem.getItemId();

        boolean isSelected= false;
        if (idMenuItemSeleccionado == R.id.page_1) {
          abrirActivity(HomeActivity.class);
          isSelected= true;
        } else if (idMenuItemSeleccionado == R.id.page_2) {
          abrirActivity(PlayerActivity.class);
          isSelected= true;
        }else if(idMenuItemSeleccionado == R.id.page_3){
          //llamar activity listas de reproduccion
          isSelected= true;
        }else if(idMenuItemSeleccionado == R.id.page_4){
          //llamar activity buscador
        }else if (idMenuItemSeleccionado == R.id.page_5){
          //llamar activity cuenta
        }
        return isSelected;
      }

      });
  }

  @Override
  public void onStart() {
    super.onStart();
    if (Util.SDK_INT > 23) {
      if(cancionesParaPlayList != null){
        initializePlayer();
      }

    }
  }

  @Override
  public void onResume() {
    super.onResume();
    hideSystemUi();
    if ((Util.SDK_INT <= 23 || player == null)) {
        initializePlayer();
    }
  }

  @Override
  public void onPause() {
    super.onPause();
    if (Util.SDK_INT <= 23) {
      releasePlayer();
    }
  }

  @Override
  public void onStop() {
    super.onStop();
    if (Util.SDK_INT > 23) {
      releasePlayer();
    }
  }

  private void initializePlayer() {
    if (player == null) {
      DefaultTrackSelector trackSelector = new DefaultTrackSelector(this);
      trackSelector.setParameters(
              trackSelector.buildUponParameters().setMaxVideoSizeSd());
      player = new SimpleExoPlayer.Builder(this)
              .setTrackSelector(trackSelector)
              .build();
    }

    playerView.setPlayer(player);
    if(cancionesParaPlayList != null){
         listaDeReproduccion =ListasDeReproduccionController.crearListaDeReproduccion(cancionesParaPlayList,listaDeReproduccion);
      /*
      MediaItem mediaItem = new MediaItem.Builder()
              .setUri(cancionParaReproducir.getUrlDeCancion())
              .setMimeType(MimeTypes.APPLICATION_MPD)
              .build();

       */
      for(MediaItem mediaItem : listaDeReproduccion){
        player.addMediaItem(mediaItem);
      }
      player.setPlayWhenReady(playWhenReady);
      player.seekTo(currentWindow, playbackPosition);
      player.prepare();
    }


  }

  private void releasePlayer() {
    if (player != null) {
      playbackPosition = player.getCurrentPosition();
      currentWindow = player.getCurrentWindowIndex();
      playWhenReady = player.getPlayWhenReady();
      player.release();
      player = null;
    }
  }

  @SuppressLint("InlinedApi")
  private void hideSystemUi() {
    playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
        | View.SYSTEM_UI_FLAG_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
  }

    private void abrirActivity(Class activityParaAbrir) {

      Intent intent = new Intent(this, activityParaAbrir);
      String message = "Bingo";
      intent.putExtra(EXTRA_MESSAGE, message);
      startActivity(intent);
    }


}
