package com.example.ancientdiggers.data.model.venta

import java.io.Serializable

enum class TipoMejora { VELOCIDAD_EXCAVACION, VACCEOCOINS }

class Venta (
    val nombre: TipoMejora,
    val coste: Int
):Serializable{

}