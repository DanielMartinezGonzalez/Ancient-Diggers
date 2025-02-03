package com.example.ancientdiggers.data.model

import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.item.Item
import com.example.ancientdiggers.data.model.terreno.Terreno
import com.example.ancientdiggers.data.model.terreno.herencia.TerrenoNormal

class Jugador {
    private val observers = mutableListOf<(Jugador) -> Unit>()
    var dinero = 0
    var hallazgos = ArrayList<Item>()
    var terrenos = ArrayList<Terreno>()

    init {
        terrenos.add(
            TerrenoNormal(nombre = "PrimerTerreno",
                descripcion = "Pues el primer terreno",
                desbloqueado = true,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "SegundoTerreno",
                descripcion = "Pues el segundo terreno",
                desbloqueado = false,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "TercerTerreno",
                descripcion = "Pues el tercer terreno",
                desbloqueado = false,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "CuartoTerreno",
                descripcion = "Pues el cuarto terreno",
                desbloqueado = false,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "QuintoTerreno",
                descripcion = "Pues el quinto terreno",
                desbloqueado = false,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "SextoTerreno",
                descripcion = "Pues el sexto terreno",
                desbloqueado = true,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "PrimerTerreno",
                descripcion = "Pues el primer terreno",
                desbloqueado = true,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "SegundoTerreno",
                descripcion = "Pues el segundo terreno",
                desbloqueado = false,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "TercerTerreno",
                descripcion = "Pues el tercer terreno",
                desbloqueado = false,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "CuartoTerreno",
                descripcion = "Pues el cuarto terreno",
                desbloqueado = false,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "QuintoTerreno",
                descripcion = "Pues el quinto terreno",
                desbloqueado = false,
                imagen = R.drawable.ic_launcher_foreground)
        )
        terrenos.add(
            TerrenoNormal(nombre = "SextoTerreno",
                descripcion = "Pues el sexto terreno",
                desbloqueado = true,
                imagen = R.drawable.ic_launcher_foreground)
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

    fun excavar(posicionTerreno: Int){
        terrenos[posicionTerreno] = terrenos.get(posicionTerreno).excavar()
    }

    private fun notifyObservers() {
        observers.forEach { it(this) }
    }
}