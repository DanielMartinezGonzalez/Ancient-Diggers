package com.example.ancientdiggers.data.model.venta

import java.io.Serializable

/*
Dataclass que representa las mejoras disponibles en la tienda y las que el jugador posee
 */
enum class TipoMejora { VELOCIDAD_EXCAVACION }

data class Venta (
    val nombreMejora: TipoMejora,
    val coste: Int
):Serializable{

}