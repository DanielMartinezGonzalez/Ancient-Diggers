package com.example.ancientdiggers.domain.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.hallazgo.Hallazgo

class HallazgoAdapter (
    private val hallazgos: List<Hallazgo>,
    private val onHallazgoCLick: (hallazgo: Hallazgo, position: Int) -> Unit
) : RecyclerView.Adapter<HallazgoAdapter.HallazgoViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HallazgoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hallazgo, parent, false)
        return HallazgoViewHolder(view)
    }

    override fun onBindViewHolder(holder: HallazgoViewHolder, position: Int) {
        val hallazgo = hallazgos[position]
        holder.bind(hallazgo)
        holder.itemView.setOnClickListener {
            onHallazgoCLick(hallazgo, position)
        }
    }

    override fun getItemCount(): Int = hallazgos.size

    class HallazgoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreHallazgo = itemView.findViewById<TextView>(R.id.nombreHallazgoTextView)
        private val culturaHallazgo = itemView.findViewById<TextView>(R.id.culturaHallazgoTextView)
        private val epocaHallazgo = itemView.findViewById<TextView>(R.id.epocaHallazgoTextView)
        private val descripcionHallazgo = itemView.findViewById<TextView>(R.id.descripcionHallazgoTextView)
        private val hallazgoImage = itemView.findViewById<ImageView>(R.id.hallazgoImageView)

        fun bind(hallazgo: Hallazgo){
            nombreHallazgo.text = hallazgo.nombre
            culturaHallazgo.text = hallazgo.cultura.toString()
            epocaHallazgo.text = hallazgo.epoca.toString()
            descripcionHallazgo.text = hallazgo.descripcion
            hallazgoImage.setImageResource(hallazgo.imagen)
        }
    }
}