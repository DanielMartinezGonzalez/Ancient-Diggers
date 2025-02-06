package com.example.ancientdiggers.ui.elements.mainfragments.dialogfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.Partida

class ExcavarDialogFragment : DialogFragment() {

    // Clave para el argumento
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
        // Recupera el índice del terreno desde los argumentos
        terrenoIndex = arguments?.getInt(ARG_TERRENO_INDEX) ?: -1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_popup_excavar, container, false)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)
        val btnExcavar = view.findViewById<Button>(R.id.btnExcavar)

        // Configura el botón "Cancelar"
        btnCancelar.setOnClickListener {
            dismiss()  // Cierra el diálogo
        }

        // Configura el botón "Excavar"
        btnExcavar.setOnClickListener {
            // Llama a la función de excavación del jugador usando el índice correspondiente
            val mensaje: String = if(Partida.jugador.solicitudExcavar(terrenoIndex)){
                "¡Nuevo objeto en el inventario!"
            } else {
                "No tienes los recursos para excavar aquí"
            }
            activity?.let {
                Toast.makeText(it, mensaje, Toast.LENGTH_SHORT).show()
            }
            dismiss()  // Cierra el diálogo
        }
        return view
    }
}
