/*
 * Práctica 6 - Gestor de Contactos con Favoritos
 * Modelo de datos que representa un contacto.
 * Autor: Kevin A. Haytara Rodriguez.
 * Fecha de creación: 04/05/2026
 * Fecha de última modificación: 04/05/2026
 */
package com.example.pdm_ejemplo6_2026.model

data class Contacto(
    val id: Int,
    val nombre: String,
    val telefono: String,
    val favorito: Boolean = false
)
