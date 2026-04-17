package com.example.pdm_ejemplo4_2026

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Resumen : AppCompatActivity() {

    private lateinit var txtNombre: TextView
    private lateinit var txtEdad: TextView
    private lateinit var txtCiudad: TextView
    private lateinit var txtCorreo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        txtNombre = findViewById(R.id.txt_Nombre)
        txtEdad   = findViewById(R.id.txt_Edad)
        txtCiudad = findViewById(R.id.txt_Ciudad)
        txtCorreo = findViewById(R.id.txt_Correo)

        if (savedInstanceState != null) {
            txtNombre.text = savedInstanceState.getString("nombre")
            txtEdad.text   = savedInstanceState.getString("edad")
            txtCiudad.text = savedInstanceState.getString("ciudad")
            txtCorreo.text = savedInstanceState.getString("correo")
        } else {
            txtNombre.text = intent.getStringExtra("nombre")
            txtEdad.text   = intent.getStringExtra("edad")
            txtCiudad.text = intent.getStringExtra("ciudad")
            txtCorreo.text = intent.getStringExtra("correo")
        }

        val btnConfirmar = findViewById<Button>(R.id.btn_Confirmar)
        btnConfirmar.setOnClickListener {
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_OK)
            finish()
        }

        val btnEditarTexto = findViewById<Button>(R.id.btn_EditarTexto)
        btnEditarTexto.setOnClickListener {
            val data = Intent()
            data.putExtra("nombre", txtNombre.text.toString())
            data.putExtra("edad",   txtEdad.text.toString())
            data.putExtra("ciudad", txtCiudad.text.toString())
            data.putExtra("correo", txtCorreo.text.toString())
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", txtNombre.text.toString())
        outState.putString("edad",   txtEdad.text.toString())
        outState.putString("ciudad", txtCiudad.text.toString())
        outState.putString("correo", txtCorreo.text.toString())
    }
}
