package com.example.ancientdiggers.domain.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.Partida
import com.example.ancientdiggers.data.model.terreno.Terreno
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavable
import com.example.ancientdiggers.data.model.terreno.terrenos.TerrenoExcavandose
import com.google.android.material.snackbar.Snackbar

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
                Snackbar.make(holder.itemView, "Este terreno no puede ser excavado", Snackbar.LENGTH_SHORT).show()
            }

        }
        holder.itemView.setOnLongClickListener {
            if(Partida.jugador.puedeComprarTerreno(position)) {
                Snackbar.make(holder.itemView, "Has comprado este terreno", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(holder.itemView, "No puedes comprar este terreno", Snackbar.LENGTH_SHORT).show()
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
        private var relojIcon: ImageView = itemView.findViewById(R.id.relojIcon)

        fun bind(terreno: Terreno) {
            if(terreno is TerrenoExcavandose){
                viewBlock.visibility = View.VISIBLE
                relojIcon.visibility = ImageView.VISIBLE
                this.bind(terreno.terreno)

            } else {
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
}
