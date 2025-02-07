package com.example.ancientdiggers.data.model

import com.example.ancientdiggers.data.factory.HallazgoFactory
import com.example.ancientdiggers.data.factory.TerrenoFactory
import com.example.ancientdiggers.data.factory.VentaFactory
import com.example.ancientdiggers.data.model.hallazgo.Hallazgo
import com.example.ancientdiggers.data.model.terreno.Terreno
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavable
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavandose
import com.example.ancientdiggers.data.model.venta.Venta

/*
Clase que presenta los datos del usuario actual de la partida y su comportamiento
 */
class Jugador {
    private val observers = mutableListOf<(Jugador) -> Unit>()
    var nombre: String = "Daniel"
    var dinero: Int = 10
    var arqueologos: Int = 1
    var hallazgos = ArrayList<Hallazgo>()
    var terrenos = ArrayList<Terreno>()
    var mejoras = HashMap<Venta, Int>()

    init {

        terrenos = TerrenoFactory.generarAllTerrenos()
        hallazgos = HallazgoFactory.generarAllHallazgos()
        mejoras = VentaFactory.generarVentasBase()
    }

    fun addObserver(observer: (Jugador) -> Unit) {
        observers.add(observer)
    }

    fun limpiarObserves() {
        observers.clear()
    }

    fun puedeComprarTerreno(posicionTerreno: Int): Boolean{
        val terreno = terrenos[posicionTerreno] as? TerrenoExcavable ?: return false
        return if (terreno.coste <= dinero && !terreno.excavable() ) {
            terreno.desbloquear()
            dinero -= terreno.coste
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
        arqueologos -= 1
        terrenos[posicionTerreno] = terreno.excavar()
    }

    fun finalizarExcavacion(posicionTerreno: Int){
        val terreno = terrenos[posicionTerreno] as TerrenoExcavandose
        arqueologos += 1
        terrenos[posicionTerreno] = terreno.finalizarExcavacion()
        notifyObservers()
    }

    fun vender(posicionHallazgo: Int){
        val hallazgo = hallazgos[posicionHallazgo]
        dinero += hallazgo.valor
        hallazgos.removeAt(posicionHallazgo)
        notifyObservers()
    }

    fun comprarMejora(mejora: Venta, cantidadComprada : Int){
        val cantidadMejora: Int = mejoras[mejora]!!
        mejoras[mejora] = cantidadMejora + cantidadComprada
        dinero -= (mejora.coste * cantidadComprada)
        notifyObservers()
    }

    private fun generarHallazgo(){
        hallazgos.add(HallazgoFactory.generarHallazgoAleatorio())
    }

    private fun notifyObservers() {
        observers.forEach { it(this) }
    }
}