package com.example.ancientdiggers.domain.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.Partida
import com.example.ancientdiggers.data.model.terreno.Terreno
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavable
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavado

class TerrenoAdapter(
    private val terrenos: List<Terreno>,
    private val onTerrenoClick: (terreno: Terreno, position: Int) -> Unit
) : RecyclerView.Adapter<TerrenoAdapter.TerrenoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerrenoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_terreno, parent, false)
        return TerrenoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TerrenoViewHolder, position: Int) {
        val terreno = terrenos[position]
        holder.bind(terreno)
        holder.itemView.setOnClickListener {
            if(terreno.excavable()) {
                onTerrenoClick(terreno, position)
            } else {
                Toast.makeText(holder.itemView.context, "Este terreno no puede ser excavado", Toast.LENGTH_SHORT).show()
            }

        }
        holder.itemView.setOnLongClickListener {
            if(Partida.jugador.puedeComprar(position)) {
                Toast.makeText(holder.itemView.context, "Has comprado este terreno", Toast.LENGTH_SHORT).show()
            } else if(terreno.excavable()){
                Toast.makeText(holder.itemView.context, "No puedes comprar este terreno", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun getItemCount(): Int = terrenos.size

    class TerrenoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.terrenoImage)
        private val textView: TextView = itemView.findViewById(R.id.terrenoText)
        private val viewBlock: View = itemView.findViewById(R.id.blockOverlay)
        private val lockIcon: ImageView = itemView.findViewById(R.id.lockIcon)

        fun bind(terreno: Terreno) {
            imageView.setImageResource(terreno.imagen)
            textView.text = terreno.nombre
            if (!terreno.excavable() && terreno is TerrenoExcavable){
                textView.text = terreno.nombre + " bloqueado"
                viewBlock.visibility = View.VISIBLE
                lockIcon.visibility = ImageView.VISIBLE
            }
        }
    }
}
