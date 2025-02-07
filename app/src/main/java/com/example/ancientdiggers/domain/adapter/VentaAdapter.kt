package com.example.ancientdiggers.domain.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.venta.Venta

class VentaAdapter (
    private val ventas: HashMap<Venta, Int>
) : RecyclerView.Adapter<VentaAdapter.VentaViewHolder> () {

    private val ventasOrdenadas: List<Venta> = ventas.keys.toList()
    private val cantidades: MutableMap<Venta, Int> = mutableMapOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VentaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_venta, parent, false)
        return VentaViewHolder(view)
    }

    override fun onBindViewHolder(holder: VentaViewHolder, position: Int) {
        val venta = ventasOrdenadas[position]

        holder.bind(venta) { cantidadSeleccionada ->
            cantidades[venta] = cantidadSeleccionada
        }
    }

    override fun getItemCount(): Int = ventas.size
    fun getSelectedQuantities(): Map<Venta, Int> = cantidades.toMap()


    class VentaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var cantidad: Int = 0
        private val nombreVenta = itemView.findViewById<TextView>(R.id.nombreVentaTextView)
        private val precioVenta = itemView.findViewById<TextView>(R.id.precioVentaTextView)
        private val btnMenos = itemView.findViewById<ImageButton>(R.id.btnMenos)
        private val btnMas = itemView.findViewById<ImageButton>(R.id.btnMas)
        private val cantidadVista = itemView.findViewById<TextView>(R.id.valorCantidadTextView)

        fun bind (venta: Venta, cambioCantidades: (Int) -> Unit) {
            nombreVenta.text = venta.nombreMejora.toString()
            precioVenta.text = venta.coste.toString()
            representarCantidad()
            btnMenos.setOnClickListener {
                if (cantidad > 0) {
                    cantidad -= 1
                    representarCantidad()
                    cambioCantidades(cantidad)
                }
            }
            btnMas.setOnClickListener {
                cantidad += 1
                representarCantidad()
                cambioCantidades(cantidad)
            }

        }

        private fun representarCantidad () {
            cantidadVista.text = cantidad.toString()

        }

    }
}