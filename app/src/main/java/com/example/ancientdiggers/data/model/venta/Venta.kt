package com.example.ancientdiggers.data.model.venta

import java.io.Serializable

enum class TipoMejora { VELOCIDAD_EXCAVACION }

data class Venta (
    val nombreMejora: TipoMejora,
    val coste: Int
):Serializable{

}