package com.example.ancientdiggers.data.model.terreno.terrenos

import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.terreno.Terreno

/*
Clase que hereda de Terreno que representa aquel que ha sido vaciado y no puede ser escavado más
 */
class TerrenoExcavado (
    nombre: String
) : Terreno(nombre){
    override fun excavable(): Boolean = false

    override var imagen: Int = R.drawable.terreno_excavado
}