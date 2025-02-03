package com.example.ancientdiggers.data.model.terreno.herencia

import com.example.ancientdiggers.data.model.terreno.Terreno

class TerrenoNormal (
    nombre: String,
    descripcion: String,
    desbloqueado: Boolean,
    imagen: Int
) : Terreno(nombre, descripcion, desbloqueado, imagen){

    override fun excavar(): TerrenoMedioExcavar{
        return TerrenoMedioExcavar(
            nombre = nombre,
            descripcion = descripcion,
            desbloqueado = desbloqueado,
            imagen = imagen
        )
    }
}