package com.example.pdm_practica5_2026.ui.screens



import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.pdm_practica5_2026.ui.content.FormularioUI

@Composable
fun FormularioScreen() {

    // Estados de los campos del formulario
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var terminos by remember { mutableStateOf(false) }
    var activo by remember { mutableStateOf(false) }
    var nivel by remember { mutableStateOf(0f) }
    var resultado by remember { mutableStateOf("") }

    //VALIDACIONES
    val errorNombre = nombre.isBlank()
    val errorEdad = edad.isBlank() || edad.toIntOrNull() == null
    val errorCorreo = !correo.contains("@")
    val errorTerminos = !terminos
    val formularioValido =
        !errorNombre && !errorEdad && !errorCorreo && !errorTerminos



    FormularioUI(
        nombre = nombre,
        edad = edad,
        correo = correo,
        genero = genero,
        terminos = terminos,
        activo = activo,
        nivel = nivel,
        resultado = resultado,
        errorNombre = errorNombre,
        errorEdad = errorEdad,
        errorCorreo = errorCorreo,
        errorTerminos = errorTerminos,
        formularioValido = formularioValido,
        onNombreChange = { nombre = it },
        onEdadChange = { edad = it },
        onCorreoChange = { correo = it },
        onGeneroChange = { genero = it },
        onTerminosChange = { terminos = it },
        onActivoChange = { activo = it },
        onNivelChange = { nivel = it },
        onRegistrar = {
            val estado = if (activo) "activo" else "inactivo"
            resultado = "Usuario $nombre, $edad años, $estado, nivel ${nivel.toInt()}"
        },
        onLimpiar = {
            nombre = ""
            edad = ""
            correo = ""
            genero = ""
            terminos = false
            activo = false
            nivel = 0f
            resultado = ""
        }
    )
}
