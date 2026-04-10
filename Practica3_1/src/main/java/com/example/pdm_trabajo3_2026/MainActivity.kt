package com.example.pdm_trabajo3_2026
/*
Decripción:
Autor: Kevin A. Haytara
Fecha de Creación: 08/04/2026
Fecha de última modificación: 10/04/2026
Tiempo de duración: 720 minutos
 */
import android.os.Bundle
import android.widget.ImageView //Hay que importar la imagen
import android.widget.Toast // sin importar no funciona


import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //segundo código en añadir
        val laPalta = findViewById<ImageView>(R.id.laPalta)
        //Aquí llama el nombre -> carpeta recurso -> carpeta dibujo -> nombre de la variaable
        laPalta.setOnClickListener{ //Aquin nueva función del ejercicico no hay otra forma de hacerlo
            Toast.makeText(this,"Hola, soy una tostada con palta", Toast.LENGTH_SHORT).show()
        }

    }
}