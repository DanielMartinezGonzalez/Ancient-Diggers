package com.example.ancientdiggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ancientdiggers.data.Partida
import com.example.ancientdiggers.data.model.Jugador
import com.example.ancientdiggers.ui.elements.MainActivity

/*
Punto de entrada de la aplicación.
Se inicializarán los datos de la sesión
 */
class PreLoadActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Partida.jugador = Jugador()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        //Evita que el usuario pueda retroceder a esta actividad
        finish()
    }
}