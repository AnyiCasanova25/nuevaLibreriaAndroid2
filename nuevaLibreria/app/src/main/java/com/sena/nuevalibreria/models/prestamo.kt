package com.sena.nuevalibreria.models

import java.util.Date

data class prestamo(
    val  fechaPrestamo: String,
    val fechaDevolucion: String,
    val nombre : String,
    val  titulo: String,
    val estado: String,
)
