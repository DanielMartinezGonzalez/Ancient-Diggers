package com.example.ancientdiggers.data


import com.example.ancientdiggers.data.model.Jugador

/*
Singleton que gestiona el estado de la partida.
Bajo la complejidad actual del videojuego sólo almacena la instancia del jugador activo
pero de aumentar la complejidad se usaría para llevar a cabo más tareas
 */
object Partida {
    lateinit var jugador: Jugador

}