package com.example.ancientdiggers.data.model.terreno

import com.example.ancientdiggers.R
import java.io.Serializable

abstract class Terreno(
    var nombre: String = "Terreno Anonimo",
    open var imagen: Int = R.drawable.img_terreno_invalido
): Serializable {
    abstract fun excavable(): Boolean

}