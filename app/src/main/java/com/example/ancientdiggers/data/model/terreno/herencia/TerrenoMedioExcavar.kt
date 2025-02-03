package com.example.ancientdiggers.data.model.terreno.herencia

import com.example.ancientdiggers.data.model.terreno.Terreno

class TerrenoMedioExcavar (
    nombre: String,
    descripcion: String,
    desbloqueado: Boolean,
    imagen: Int
) : Terreno(nombre, descripcion, desbloqueado, imagen){
    override fun excavar(): Terreno {
        TODO("Not yet implemented")
    }


}