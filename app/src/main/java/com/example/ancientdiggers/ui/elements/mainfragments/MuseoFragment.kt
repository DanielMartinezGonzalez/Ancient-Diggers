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
import com.example.ancientdiggers.data.model.hallazgo.Hallazgo
import com.example.ancientdiggers.domain.adapter.HallazgoAdapter
import com.example.ancientdiggers.ui.elements.mainfragments.dialogfragments.InfoHallazgoDialogFragment


class MuseoFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HallazgoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_museo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewItems)
        recyclerView.layoutManager = GridLayoutManager(context, 1)

        actualizarMuseo()
        Partida.jugador.addObserver {
            actualizarMuseo()
        }
    }

    private fun actualizarMuseo(){
        val hallazgos: List<Hallazgo> = Partida.jugador.hallazgos
        adapter = HallazgoAdapter(hallazgos) {hallazgo, posicion ->
            mostrarHallazgo(posicion)
        }
        recyclerView.adapter = adapter
    }

    private fun mostrarHallazgo(index: Int) {
        val dialog = InfoHallazgoDialogFragment.newInstance(index)
        dialog.show(childFragmentManager, "InfoHallazgoDialogFragment")
    }
}