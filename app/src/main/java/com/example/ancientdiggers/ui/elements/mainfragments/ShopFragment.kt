package com.example.ancientdiggers.ui.elements.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.Partida
import com.example.ancientdiggers.domain.adapter.VentaAdapter


class ShopFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VentaAdapter
    private lateinit var btnComprar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewShop)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        btnComprar = view.findViewById(R.id.btnComprar)

        actualizarTienda()
        Partida.jugador.addObserver {
            actualizarTienda()
        }
    }

    private fun actualizarTienda(){

    }
}