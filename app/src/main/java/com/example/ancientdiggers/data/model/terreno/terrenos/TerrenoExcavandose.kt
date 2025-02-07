package com.example.ancientdiggers.data.model.terreno.terrenos

import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.terreno.Terreno

class TerrenoExcavandose (
    nombre: String,
    val terreno: Terreno
) : Terreno(nombre) {

    fun finalizarExcavacion(): Terreno {
        return terreno
    }

    override fun excavable(): Boolean = false

}