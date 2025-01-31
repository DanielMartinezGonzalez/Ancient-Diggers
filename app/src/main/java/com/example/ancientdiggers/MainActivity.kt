package com.example.ancientdiggers

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ancientdiggers.ui.elements.MapActivity

/*
Punto de entrada de la aplicación.
Se inicializarán los datos de la sesión
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
        //Evita que el usuario pueda retroceder a esta actividad
        finish()
    }
}