package com.example.ancientdiggers.data.factory

import com.example.ancientdiggers.data.model.terreno.Terreno
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavable
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavado
import com.example.ancientdiggers.data.model.terreno.terrenos.excavables.TerrenoMedioExcavar

/*
Factoría usada para generar clases Terreno
 */
object TerrenoFactory {

    /*
    Genera todos los posibles Terrenos
     */
    fun generarAllTerrenos (): ArrayList<Terreno> {
        return arrayListOf(
            TerrenoExcavable(nombre = "PrimerTerreno",
                desbloqueado = true,
                coste = 0),
            TerrenoExcavable(nombre = "SegundoTerreno",
                desbloqueado = false,
                coste = 0),
            TerrenoMedioExcavar(nombre = "TercerTerreno",
                desbloqueado = true,
                coste = 0),
            TerrenoMedioExcavar(nombre = "CuartoTerreno",
                desbloqueado = false,
                coste = 0),
            TerrenoExcavado(nombre = "QuintoTerreno"),
            TerrenoExcavable(nombre = "SextoTerreno",
                desbloqueado = true,
                coste = 10),
            TerrenoExcavable(nombre = "SeptimoTerreno",
                desbloqueado = false,
                coste = 10),
            TerrenoMedioExcavar(nombre = "OctavoTerreno",
                desbloqueado = true,
                coste = 10),
            TerrenoMedioExcavar(nombre = "NovenoTerreno",
                desbloqueado = false,
                coste = 10),
            TerrenoExcavable(nombre = "DecimoTerreno",
                desbloqueado = true,
                coste = 11),
            TerrenoExcavable(nombre = "UndecimoTerreno",
                desbloqueado = false,
                coste = 11),
            TerrenoMedioExcavar(nombre = "DuodecimoTerreno",
                desbloqueado = true,
                coste = 11),
            TerrenoMedioExcavar(nombre = "TridecimoTerreno",
                desbloqueado = false,
                coste = 11)
        )
    }
}