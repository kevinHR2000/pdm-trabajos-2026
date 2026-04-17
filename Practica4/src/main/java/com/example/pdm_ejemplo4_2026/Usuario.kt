package com.example.pdm_ejemplo4_2026

import java.io.Serializable
//Una clase Objeto con las varibales, en ves de colocar viewtext con ID
data class Usuario(
    val nombre: String,
    val ciudad: String,
    val edad: String,
    val correo: String,
) : Serializable