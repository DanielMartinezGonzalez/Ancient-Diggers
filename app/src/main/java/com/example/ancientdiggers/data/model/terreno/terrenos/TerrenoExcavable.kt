package com.example.ancientdiggers.data.model.terreno.terrenos

import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.terreno.Terreno
import com.example.ancientdiggers.data.model.terreno.terrenos.excavables.TerrenoMedioExcavar

/*
Clase que hereda de Terreno y de la que heredan todos los terrenos que puedan ser excavables (Ahora mismo sólo TerrenoMedioExcavado)

Representa los terrenos que pueden ser excavable y su comportamiento
 */
open class TerrenoExcavable (
    nombre: String,
    private var desbloqueado: Boolean = true,
    val coste: Int
    ) : Terreno(nombre){

    override var imagen: Int = listOf(
        R.drawable.terreno_excavable_1,
        R.drawable.terreno_excavable_2,
        R.drawable.terreno_excavable_3
    ).random()


    open fun excavar(): Terreno{
        return TerrenoExcavandose(nombre, TerrenoMedioExcavar(nombre, desbloqueado, coste))
    }

    fun desbloquear() {
        desbloqueado = true
    }

    override fun excavable(): Boolean {
        return desbloqueado
    }

}