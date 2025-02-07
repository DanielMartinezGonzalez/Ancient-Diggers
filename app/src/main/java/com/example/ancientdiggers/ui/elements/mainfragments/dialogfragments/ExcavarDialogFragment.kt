package com.example.ancientdiggers.ui.elements.mainfragments.dialogfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.DialogFragment
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.Partida

class ExcavarDialogFragment : DialogFragment() {

    companion object {
        private const val ARG_TERRENO_INDEX = "terreno_index"

        fun newInstance(terrenoIndex: Int): ExcavarDialogFragment {
            val fragment = ExcavarDialogFragment()
            val args = Bundle()
            args.putInt(ARG_TERRENO_INDEX, terrenoIndex)
            fragment.arguments = args
            return fragment
        }
    }

    private var terrenoIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        terrenoIndex = arguments?.getInt(ARG_TERRENO_INDEX) ?: -1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_popup_excavar, container, false)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)
        val btnExcavar = view.findViewById<Button>(R.id.btnExcavar)

        btnCancelar.setOnClickListener {
            dismiss()
        }

        btnExcavar.setOnClickListener {
            val mensaje: String = if(Partida.jugador.solicitudExcavar(terrenoIndex)){
                "¡Nuevo objeto en el inventario!"
            } else {
                "No tienes los recursos para excavar aquí"
            }
            activity?.let {
                Snackbar.make(view, mensaje, Snackbar.LENGTH_SHORT).show()
            }
            dismiss()
        }
        return view
    }
}
