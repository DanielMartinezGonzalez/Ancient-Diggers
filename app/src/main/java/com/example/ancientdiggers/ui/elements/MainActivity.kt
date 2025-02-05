package com.example.ancientdiggers.ui.elements

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.Partida
import com.example.ancientdiggers.data.model.Jugador
import com.example.ancientdiggers.ui.elements.mainfragments.MuseoFragment
import com.example.ancientdiggers.ui.elements.mainfragments.MapFragment
import com.example.ancientdiggers.ui.elements.mainfragments.ShopFragment

class MainActivity : AppCompatActivity() {
    private lateinit var arqueoValor: TextView
    private lateinit var dineroValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arqueoValor = findViewById(R.id.arqueologosTextView)
        dineroValor = findViewById(R.id.dineroTextView)
        val nombreText: TextView = findViewById(R.id.tituloToolBar)
        nombreText.text = Partida.jugador.nombre
        cargarFragment(MapFragment())
        val btnMap: Button = findViewById(R.id.bottom_map)
        val btnShop: Button = findViewById(R.id.bottom_shop)
        val btnInv: Button = findViewById(R.id.bottom_inventory)

        btnMap.setOnClickListener { cargarFragment(MapFragment()) }
        btnShop.setOnClickListener { cargarFragment(ShopFragment()) }
        btnInv.setOnClickListener { cargarFragment(MuseoFragment()) }

    }

    private fun cargarFragment(fragment: Fragment){
        val transaccion = supportFragmentManager.beginTransaction()
        transaccion.replace(R.id.fragmentContainer, fragment)
        transaccion.commit()
        cargarObservers(Partida.jugador)
    }


    private fun cargarObservers(jugador: Jugador){
        jugador.reset()
        jugador.addObserver {
            arqueoValor.text = it.arqueologos.toString()
            dineroValor.text = it.dinero.toString()
        }
    }
}