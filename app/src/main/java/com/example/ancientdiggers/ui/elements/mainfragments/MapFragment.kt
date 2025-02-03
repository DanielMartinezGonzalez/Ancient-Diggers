package com.example.ancientdiggers.ui.elements.mainfragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.Partida
import com.example.ancientdiggers.data.model.terreno.Terreno
import com.example.ancientdiggers.domain.adapter.TerrenoAdapter

class MapFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TerrenoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewTerrenos)
        recyclerView.layoutManager = GridLayoutManager(context, 3)

        actualizarTerrenos()
    }

    fun actualizarTerrenos(){
        val terrenos: List<Terreno> = Partida.jugador.terrenos
        adapter = TerrenoAdapter(terrenos) {terreno, position ->
            mostrarExcavar(position)
        }
        recyclerView.adapter = adapter
    }

    private fun mostrarExcavar(terrenoIndex: Int) {
        // Ejemplo usando AlertDialog
        AlertDialog.Builder(requireContext())
            .setTitle("¿Qué quieres hacer?")
            .setMessage("Selecciona una opción")
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Excavar") { dialog, _ ->
                // Llamamos a la función de excavación con el índice del terreno
                Partida.jugador.excavar(terrenoIndex)
                dialog.dismiss()
            }
            .show()
    }
}
