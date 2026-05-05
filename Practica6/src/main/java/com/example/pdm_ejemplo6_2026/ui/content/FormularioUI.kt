/*
 * Práctica 6 - Gestor de Contactos con Favoritos
 * Composición visual del formulario de contacto.
 * Autor: Kevin A. Haytara Rodriguez.
 * Fecha de creación: 04/05/2026
 * Fecha de última modificación: 04/05/2026
 */
package com.example.pdm_ejemplo6_2026.ui.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pdm_ejemplo6_2026.ui.components.CampoTexto

@Composable
fun FormularioUI(
    nombre: String,
    telefono: String,
    errorNombre: Boolean,
    errorTelefono: Boolean,
    formularioValido: Boolean,
    onNombreChange: (String) -> Unit,
    onTelefonoChange: (String) -> Unit,
    onGuardar: () -> Unit,
    onCancelar: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            "Nuevo contacto",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        CampoTexto(nombre, "Nombre", errorNombre, "Nombre es obligatorio", onNombreChange)
        CampoTexto(telefono, "Teléfono", errorTelefono, "Teléfono inválido", onTelefonoChange)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onCancelar,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancelar")
            }
            Button(
                onClick = onGuardar,
                enabled = formularioValido,
                modifier = Modifier.weight(1f)
            ) {
                Text("Guardar")
            }
        }
    }
}
