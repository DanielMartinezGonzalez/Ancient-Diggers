package com.example.ancientdiggers.data

import android.app.Activity
import android.content.Context
import com.example.ancientdiggers.data.model.Jugador
import java.lang.ref.WeakReference

object Partida {
    lateinit var jugador: Jugador
    private var contexto: WeakReference<Context>? = null

    val context: Activity?
        get() = contexto?.get() as? Activity

    fun setScontexto(context: WeakReference<Context>){
        contexto = context
    }

    fun reset() {
        return reset()
        contexto = null
    }
}