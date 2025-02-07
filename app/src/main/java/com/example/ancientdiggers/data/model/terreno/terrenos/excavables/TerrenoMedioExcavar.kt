package com.example.ancientdiggers.data.model.terreno.terrenos.excavables

import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavable
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavado

class TerrenoMedioExcavar (
    nombre: String,
    desbloqueado: Boolean = true,
    coste: Int
) : TerrenoExcavable(nombre, desbloqueado, coste){

    override var imagen: Int = R.drawable.terreno_medio_excavado

    override fun excavar(): TerrenoExcavado {
        return TerrenoExcavado(nombre)
    }


}