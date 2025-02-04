package com.example.ancientdiggers.data.model

import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.item.Item
import com.example.ancientdiggers.data.model.terreno.Terreno
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavable
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavado
import com.example.ancientdiggers.data.model.terreno.terrenos.excavables.TerrenoMedioExcavar

class Jugador {
    private val observers = mutableListOf<(Jugador) -> Unit>()
    var dinero = 10
    var arqueologos = 1
    var hallazgos = ArrayList<Item>()
    var terrenos = ArrayList<Terreno>()

    init {
        terrenos.add(
            TerrenoExcavable(nombre = "PrimerTerreno",
                desbloqueado = true,
                coste = 0.0)
        )
        terrenos.add(
            TerrenoExcavable(nombre = "SegundoTerreno",
                desbloqueado = false,
                coste = 0.0)
        )
        terrenos.add(
            TerrenoMedioExcavar(nombre = "TercerTerreno",
                desbloqueado = true,
                coste = 0.0)
        )
        terrenos.add(
            TerrenoMedioExcavar(nombre = "CuartoTerreno",
                desbloqueado = false,
                coste = 0.0)
        )
        terrenos.add(
            TerrenoExcavado(nombre = "QuintoTerreno")
        )
        terrenos.add(
            TerrenoExcavable(nombre = "SextoTerreno",
                desbloqueado = true,
                coste = 10.0)
        )
        terrenos.add(
            TerrenoExcavable(nombre = "SeptimoTerreno",
                desbloqueado = false,
                coste = 10.0)
        )
        terrenos.add(
            TerrenoMedioExcavar(nombre = "OctavoTerreno",
                desbloqueado = true,
                coste = 10.0)
        )
        terrenos.add(
            TerrenoMedioExcavar(nombre = "NovenoTerreno",
                desbloqueado = false,
                coste = 10.0)
        )
        terrenos.add(
            TerrenoExcavable(nombre = "DecimoTerreno",
                desbloqueado = true,
                coste = 10.1)
        )
        terrenos.add(
            TerrenoExcavable(nombre = "UndecimoTerreno",
                desbloqueado = false,
                coste = 10.1)
        )
        terrenos.add(
            TerrenoMedioExcavar(nombre = "DuodecimoTerreno",
                desbloqueado = true,
                coste = 10.1)
        )
        terrenos.add(
            TerrenoMedioExcavar(nombre = "TridecimoTerreno",
                desbloqueado = false,
                coste = 10.1)
        )

    }

    fun addObserver(observer: (Jugador) -> Unit) {
        observers.add(observer)
    }

    fun removeObserver(observer: (Jugador) -> Unit) {
        observers.remove(observer)
    }

    fun reset() {
        observers.clear()
    }

    fun puedeComprar(posicionTerreno: Int): Boolean{
        val terreno = terrenos[posicionTerreno] as? TerrenoExcavable ?: return false
        return if (terreno.coste <= dinero && !terreno.excavable() ) {
            terreno.desbloquear()
            notifyObservers()
            true
        } else {
            false
        }
    }

    fun solicitudExcavar(posicionTerreno: Int): Boolean{
        val puedeExcavar = arqueologos > 0
        if (puedeExcavar) {
            excavar(posicionTerreno)
            generarHallazgo()
        }
        notifyObservers()
        return puedeExcavar
    }

    private fun excavar(posicionTerreno: Int){
        val terreno = terrenos[posicionTerreno] as TerrenoExcavable
        terrenos[posicionTerreno] = terreno.excavar()
    }

    private fun generarHallazgo(){

    }

    private fun notifyObservers() {
        observers.forEach { it(this) }
    }
}