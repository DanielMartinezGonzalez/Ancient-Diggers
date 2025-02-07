package com.example.ancientdiggers.data.model.terreno.terrenos

import com.example.ancientdiggers.data.model.terreno.Terreno

/*
Clase que hereda de Terreno que sirve de clase intermedia entre los terrenos excavables.
Almacena el terreno que ocupará lugar cuando se finalize la excavación
 */
class TerrenoExcavandose (
    nombre: String,
    val terreno: Terreno
) : Terreno(nombre) {

    fun finalizarExcavacion(): Terreno {
        return terreno
    }

    override fun excavable(): Boolean = false

}