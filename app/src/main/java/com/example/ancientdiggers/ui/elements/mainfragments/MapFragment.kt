package com.example.ancientdiggers.ui.elements.mainfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.Partida
import com.example.ancientdiggers.data.model.terreno.Terreno
import com.example.ancientdiggers.domain.adapter.TerrenoAdapter
import com.example.ancientdiggers.ui.elements.mainfragments.dialogfragments.ExcavarDialogFragment

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
        Partida.jugador.addObserver { actualizarTerrenos() }
    }

    private fun actualizarTerrenos(){
        val terrenos: List<Terreno> = Partida.jugador.terrenos
        adapter = TerrenoAdapter(terrenos) {terreno, position ->
            mostrarExcavar(position)
        }
        recyclerView.adapter = adapter
    }

    private fun mostrarExcavar(terrenoIndex: Int) {
        val dialog = ExcavarDialogFragment.newInstance(terrenoIndex)
        dialog.show(childFragmentManager, "ExcavarDialogFragment")
    }
}
