package com.example.ancientdiggers.domain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.terreno.Terreno

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
        // Aquí vincula el objeto terreno a los elementos de la vista (por ejemplo, establecer imagen y nombre)
        holder.bind(terreno)
        holder.itemView.setOnClickListener {
            onTerrenoClick(terreno, position)
        }
    }

    override fun getItemCount(): Int = terrenos.size

    class TerrenoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.terrenoImage)
        fun bind(terreno: Terreno) {
            imageView.setImageResource(terreno.imagen)
            // Puedes agregar más binding de datos según la información de terreno
        }
    }
}
