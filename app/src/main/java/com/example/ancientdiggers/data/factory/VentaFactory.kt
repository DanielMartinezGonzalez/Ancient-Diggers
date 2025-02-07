package com.example.ancientdiggers.data.factory

import com.example.ancientdiggers.data.model.venta.TipoMejora
import com.example.ancientdiggers.data.model.venta.Venta

object VentaFactory {
    fun generarVentasBase(): HashMap<Venta, Int> {
        return hashMapOf(
            Pair(Venta(TipoMejora.VELOCIDAD_EXCAVACION, 50), 0)
        )
    }
}