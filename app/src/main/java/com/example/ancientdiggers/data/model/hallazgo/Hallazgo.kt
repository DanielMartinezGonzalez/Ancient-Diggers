package com.example.ancientdiggers.data.model.hallazgo

import java.io.Serializable

enum class TipoCultura { PALEOLITICO, NEOLITICO, EDAD_DE_BRONCE, IBERO, CELTA, CELTIBERO, VACCEO, ROMANO, VISIGODO, ASTURIANO, MUSULMAN, CONTEMPORANEO, DESCONOCIDO }
enum class TipoEpoca { PREHISTORIA, ANTIGÜEDAD, ROMANA, EDAD_MEDIA, CONTEMPORANEO, DESCONOCIDO }

class Hallazgo(
    val nombre: String,
    val cultura: TipoCultura,
    val epoca: TipoEpoca,
    val descripcion: String,
    val imagen: Int,
    val valor: Int
): Serializable {


}