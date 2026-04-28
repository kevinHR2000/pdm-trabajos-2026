package com.example.pdm_practica5_2026.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pdm_practica5_2026.ui.components.CampoTexto

@Composable
fun FormularioUI(
    nombre: String,
    edad: String,
    correo: String,
    genero: String,
    terminos: Boolean,
    activo: Boolean,
    nivel: Float,
    resultado: String,
    errorNombre: Boolean,
    errorEdad: Boolean,
    errorCorreo: Boolean,
    errorTerminos: Boolean,
    formularioValido: Boolean,
    onNombreChange: (String) -> Unit,
    onEdadChange: (String) -> Unit,
    onCorreoChange: (String) -> Unit,
    onGeneroChange: (String) -> Unit,
    onTerminosChange: (Boolean) -> Unit,
    onActivoChange: (Boolean) -> Unit,
    onNivelChange: (Float) -> Unit,
    onRegistrar: () -> Unit,
    onLimpiar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.LightGray)
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            "Registro de Usuario",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        CampoTexto(nombre, "Nombre", errorNombre,
            "Nombre es obligatorio", onNombreChange)

        CampoTexto(edad, "Edad", errorEdad, "Edad inválida", onEdadChange)

        CampoTexto(correo, "Correo electrónico", errorCorreo,
            "Correo inválido (debe contener @)", onCorreoChange)

        Text("Género", style = MaterialTheme.typography.titleMedium)
        val opcionesGenero = listOf("Masculino", "Femenino", "Otro")
        opcionesGenero.forEach { opcion ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = genero == opcion,
                    onClick = { onGeneroChange(opcion) }
                )
                Text(opcion)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = terminos,
                onCheckedChange = onTerminosChange
            )
            Text("Acepto los términos y condiciones")
        }
        if (errorTerminos) {
            Text(
                text = "Debes aceptar los términos",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = activo,
                onCheckedChange = onActivoChange
            )
            Spacer(modifier = Modifier.height(0.dp))
            Text(
                if (activo) "  Usuario activo" else "  Usuario inactivo"
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Nivel: ${nivel.toInt()}")
        Slider(
            value = nivel,
            onValueChange = onNivelChange,
            valueRange = 0f..10f,
            steps = 9
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onRegistrar,
            enabled = formularioValido
        ) {
            Text("Registrar")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onLimpiar) {
            Text("Limpiar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = resultado)
    }
}
