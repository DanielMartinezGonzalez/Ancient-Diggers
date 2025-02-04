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
    override var imagen: Int = if (desbloqueado) {
        R.drawable.img_medio_excavar
    } else {
        R.drawable.img_terreno_bloqueado
    }

    // Esta función en TerrenoExcavable retorna un objeto que indica que se ha iniciado la excavación.
    override fun excavar(): TerrenoExcavado {
        // Aquí la implementación podría ser abstracta o devolver un objeto base.
        // Se deja como ejemplo:
        return TerrenoExcavado(nombre)
    }


}