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
import com.example.ancientdiggers.data.factory.VentaFactory
import com.example.ancientdiggers.data.model.venta.Venta
import com.example.ancientdiggers.domain.adapter.VentaAdapter
import com.google.android.material.snackbar.Snackbar


class ShopFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VentaAdapter
    private lateinit var btnComprar: Button
    private lateinit var ventas: HashMap<Venta, Int>

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
        ventas = VentaFactory.generarVentasBase()
        adapter = VentaAdapter(ventas)
        recyclerView.adapter = adapter

        btnComprar.setOnClickListener {
            val seleccionadas = adapter.getSelectedQuantities()
            seleccionadas.forEach { (venta, cantidad) ->
                if (cantidad > 0) {
                    Partida.jugador.comprarMejora(venta, cantidad)
                }
            }
            Snackbar.make(view, "Compra realizada", Snackbar.LENGTH_SHORT).show()        }
    }

}