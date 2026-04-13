/*
Descripción: Reproductor de música con 3 botones
Autor: Kevin A. Haytara
Fecha de creación: 10/04/2026
Ultima Modificación: 13/04/2026
Duración: 760 minutos
 */



package com.example.pdm_trabajo3_2_2026

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Iniciar  con el archivo musica.mp3
        mediaPlayer = MediaPlayer.create(this, R.raw.musica)

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnStop = findViewById<Button>(R.id.btnStop)

        btnPlay.setOnClickListener {
            mediaPlayer?.start()
        }

        btnPause.setOnClickListener {
            mediaPlayer?.pause()
        }

        btnStop.setOnClickListener {
            mediaPlayer?.stop()
            // Reiniciar, debemos prepararlo de nuevo para la próxima vez
            mediaPlayer = MediaPlayer.create(this, R.raw.musica)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
