package com.example.pdm_ejemplo4_2026

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
/*
Descripción: Inicia sección, rellenar y editar
Autor: Kevin A. Haytara
Fecha de Creación: 16/04/2026
Fecha de última modificación: 17/04/2026

Práctica 1: terminado; Duración: 90 minutos
Prácitca 2: terminado; Duración: 180 minutos
 */

class Formulario : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText


    private val resumenLauncher = registerForActivityResult( //La funci►2n que incializara antes del onCreate
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            etNombre.setText(data?.getStringExtra("nombre"))
            etEdad.setText(data?.getStringExtra("edad"))
            etCiudad.setText(data?.getStringExtra("ciudad"))
            etCorreo.setText(data?.getStringExtra("correo"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        etNombre = findViewById(R.id.et_Nombre)
        etEdad   = findViewById(R.id.et_Edad)
        etCiudad = findViewById(R.id.et_Ciudad)
        etCorreo = findViewById(R.id.et_Correo)

        savedInstanceState?.let {
            etNombre.setText(it.getString("nombre"))
            etEdad.setText(it.getString("edad"))
            etCiudad.setText(it.getString("ciudad"))
            etCorreo.setText(it.getString("correo"))
        }

        val btnContinuar = findViewById<Button>(R.id.btn_Continuar)
        btnContinuar.setOnClickListener {
            if (validarCampos()) {
                val intent = Intent(this, Resumen::class.java)
                intent.putExtra("nombre", etNombre.text.toString())
                intent.putExtra("edad",   etEdad.text.toString())
                intent.putExtra("ciudad", etCiudad.text.toString())
                intent.putExtra("correo", etCorreo.text.toString())
                resumenLauncher.launch(intent)
            }
        }
    }

    private fun validarCampos(): Boolean {
        var valido = true

        if (etNombre.text.toString() == null || etNombre.text.toString().isEmpty()) {
            etNombre.error = "invalido"
            valido = false
        }
        if (etEdad.text.toString() == null || etEdad.text.toString().isEmpty()) {
            etEdad.error = "invalido"
            valido = false
        }
        if (etCiudad.text.toString() == null || etCiudad.text.toString().isEmpty()) {
            etCiudad.error = "invalido"
            valido = false
        }
        if (etCorreo.text.toString() == null || etCorreo.text.toString().isEmpty()) {
            etCorreo.error = "invalido"
            valido = false
        }

        return valido
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", etNombre.text.toString())
        outState.putString("edad",   etEdad.text.toString())
        outState.putString("ciudad", etCiudad.text.toString())
        outState.putString("correo", etCorreo.text.toString())
    }
}
