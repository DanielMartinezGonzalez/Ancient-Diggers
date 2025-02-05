package com.example.ancientdiggers.data.model.terreno.terrenos.excavables

import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavable
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavado

class TerrenoMedioExcavar (
    nombre: String,
    desbloqueado: Boolean = true,
    coste: Double
) : TerrenoExcavable(nombre, desbloqueado, coste){

    // En TerrenoExcavable, la imagen se asigna según el estado
    override var imagen: Int = R.drawable.terreno_medio_excavado

    override fun excavar(): TerrenoExcavado {
        return TerrenoExcavado(nombre)
    }


}