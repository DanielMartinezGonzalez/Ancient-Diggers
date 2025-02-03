package com.example.ancientdiggers.ui.elements

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ancientdiggers.MockUpFragment
import com.example.ancientdiggers.R
import com.example.ancientdiggers.ui.elements.mainfragments.MapFragment
import com.example.ancientdiggers.ui.elements.mainfragments.ShopFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cargarFragment(MapFragment())
        val btnMap: Button = findViewById(R.id.bottom_map)
        val btnShop: Button = findViewById(R.id.bottom_shop)
        val btnInv: Button = findViewById(R.id.bottom_inventory)

        btnMap.setOnClickListener { cargarFragment(MapFragment()) }
        btnShop.setOnClickListener { cargarFragment(ShopFragment()) }
        btnInv.setOnClickListener { cargarFragment(MapFragment()) }

    }

    private fun cargarFragment(fragment: Fragment){
        val transaccion = supportFragmentManager.beginTransaction()
        transaccion.replace(R.id.fragmentContainer, fragment)
        transaccion.commit()
    }
}