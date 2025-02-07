package com.example.ancientdiggers.domain

import android.app.IntentService
import android.content.Intent
import android.content.Context
import com.example.ancientdiggers.data.Partida


class ExcavacionService : IntentService("ExcavacionService") {

    override fun onHandleIntent(intent: Intent?) {
        intent?.let {
            // Se recupera la posición del terreno y la cantidad de mejoras (número de upgrades)
            val posicion = it.getIntExtra("posicion", -1)
            val mejorasCount = it.getIntExtra("mejorasCount", 0)

            val baseTimeMillis = 2 * 60 * 1000L
            val factor = Math.pow(0.5, mejorasCount.toDouble())
            val delayMillis = (baseTimeMillis * factor).toLong()

            Thread.sleep(delayMillis)

            Partida.jugador.finalizarExcavacion(posicion)
        }
    }
}
