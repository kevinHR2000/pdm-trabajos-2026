/*
Descripción: Gestor de contactos con favoritos. Aplicación de práctica que permite
listar, marcar como favoritos y eliminar contactos, navegando entre pantallas.
Autor: Kevin A. Haytara Rodriguez.
Fecha de creación: 04/05/2026
Fecha de última modificación: 04/05/2026
 */
package com.example.pdm_ejemplo6_2026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pdm_ejemplo6_2026.ui.screens.FormularioScreen
import com.example.pdm_ejemplo6_2026.ui.screens.ListaScreen
import com.example.pdm_ejemplo6_2026.ui.theme.PdmEjemplo62026Theme

object Rutas {
    const val LISTA = "lista"
    const val FORMULARIO = "formulario"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PdmEjemplo62026Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.LISTA) {
        composable(Rutas.LISTA) {
            ListaScreen(
                onIrAFormulario = { navController.navigate(Rutas.FORMULARIO) }
            )
        }
        composable(Rutas.FORMULARIO) {
            FormularioScreen(
                onGuardar = { navController.popBackStack() },
                onCancelar = { navController.popBackStack() }
            )
        }
    }
}

