/*
 * Práctica 6 - Gestor de Contactos con Favoritos
 * Pantalla de formulario para registrar un contacto (Nombre + Teléfono).
 * Botón Guardar regresa a la pantalla anterior; el alta a la lista se ignora a propósito.
 * Autor: Kevin A. Haytara Rodriguez.
 * Fecha de creación: 04/05/2026
 * Fecha de última modificación: 04/05/2026
 */
package com.example.pdm_ejemplo6_2026.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.pdm_ejemplo6_2026.ui.content.FormularioUI

@Composable
fun FormularioScreen(onGuardar: () -> Unit, onCancelar: () -> Unit) {

    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    val errorNombre = nombre.isBlank()
    val errorTelefono = telefono.isBlank() || telefono.any { !it.isDigit() && it != '-' && it != ' ' }
    val formularioValido = !errorNombre && !errorTelefono

    FormularioUI(
        nombre = nombre,
        telefono = telefono,
        errorNombre = errorNombre,
        errorTelefono = errorTelefono,
        formularioValido = formularioValido,
        onNombreChange = { nombre = it },
        onTelefonoChange = { telefono = it },
        onGuardar = onGuardar,
        onCancelar = onCancelar
    )
}
