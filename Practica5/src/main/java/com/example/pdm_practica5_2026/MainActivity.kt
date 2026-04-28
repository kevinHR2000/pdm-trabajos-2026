package com.example.pdm_practica5_2026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pdm_practica5_2026.ui.screens.FormularioScreen
import com.example.pdm_practica5_2026.ui.theme.Pdm_practica5_2026Theme

/*
Descripción:
Autor: Kevin A. Haytara
Fecha de creación: 27/04/2026
Fecha de última modificación: 27/04/2026
Duración:
 */

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormularioScreen()
        }
        /*
        setContent {
            FormularioCompose20261Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        */
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pdm_practica5_2026Theme {
        FormularioScreen()
    }
}