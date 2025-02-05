package com.example.ancientdiggers.data.model.terreno.terrenos

import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.terreno.Terreno

class TerrenoExcavado (
    nombre: String
) : Terreno(nombre){
    override fun excavable(): Boolean {
        return false
    }

    override var imagen: Int = R.drawable.terreno_excavado
}