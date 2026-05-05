/*
 * Práctica 6 - Gestor de Contactos con Favoritos
 * Pantalla con la lista de contactos: muestra LazyColumn con favoritos al inicio,
 * permite eliminar y marcar/desmarcar favoritos, y un FAB para ir al formulario.
 * Autor: Kevin A. Haytara Rodriguez.
 * Fecha de creación: 04/05/2026
 * Fecha de última modificación: 04/05/2026
 */
package com.example.pdm_ejemplo6_2026.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pdm_ejemplo6_2026.model.Contacto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaScreen(onIrAFormulario: () -> Unit) {

    var contactos by remember {
        mutableStateOf(
            listOf(
                Contacto(1, "Ana López", "555-1010", favorito = true),
                Contacto(2, "Bruno García", "555-2020"),
                Contacto(3, "Carla Pérez", "555-3030", favorito = true),
                Contacto(4, "Diego Ruiz", "555-4040"),
                Contacto(5, "Elena Soto", "555-5050")
            )
        )
    }

    val contactosOrdenados = contactos.sortedByDescending { it.favorito }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Contactos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onIrAFormulario) {
                Icon(Icons.Default.Add, contentDescription = "Agregar contacto")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(contactosOrdenados, key = { it.id }) { contacto ->
                ContactoItem(
                    contacto = contacto,
                    onToggleFavorito = {
                        contactos = contactos.map {
                            if (it.id == contacto.id) it.copy(favorito = !it.favorito) else it
                        }
                    },
                    onEliminar = {
                        contactos = contactos.filterNot { it.id == contacto.id }
                    }
                )
            }
        }
    }
}

@Composable
private fun ContactoItem(
    contacto: Contacto,
    onToggleFavorito: () -> Unit,
    onEliminar: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(contacto.nombre, style = MaterialTheme.typography.titleMedium)
                Text(contacto.telefono, style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(onClick = onToggleFavorito) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = if (contacto.favorito) "Quitar favorito" else "Marcar favorito",
                    tint = if (contacto.favorito) Color(0xFFFFC107) else MaterialTheme.colorScheme.outline
                )
            }
            IconButton(onClick = onEliminar) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar contacto",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
