package com.example.ancientdiggers.data.model.terreno

import com.example.ancientdiggers.data.model.terreno.herencia.TerrenoMedioExcavar
import java.io.Serializable

abstract class Terreno(
    val nombre: String,
    val descripcion: String,
    val desbloqueado: Boolean,
    val imagen: Int
): Serializable {

    abstract fun excavar() : Terreno
}