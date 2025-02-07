package com.example.ancientdiggers.data.factory

import com.example.ancientdiggers.data.model.venta.TipoMejora
import com.example.ancientdiggers.data.model.venta.Venta

/*
Objeto factoria para generar las clases Venta

Se generan a cantidad seleccionadas 0.
Ahora sólo existe un tipo de mejora disponible en la tienda
 */
object VentaFactory {
    fun generarVentasBase(): HashMap<Venta, Int> {
        return hashMapOf(
            Pair(Venta(TipoMejora.VELOCIDAD_EXCAVACION, 50), 0)
        )
    }
}