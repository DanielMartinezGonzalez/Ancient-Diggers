package com.example.ancientdiggers.ui.elements.mainfragments.dialogfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.Partida
import com.example.ancientdiggers.data.model.hallazgo.Hallazgo
import org.w3c.dom.Text


class InfoHallazgoDialogFragment : DialogFragment() {

    companion object {
        private const val ARG_HALLAZGO_INDEX = "hallazgo_index"
        private const val ARG_HALLAZGO_ITEM = "hallazgo_item"

        fun newInstance(hallazgoIndex: Int, hallazgo: Hallazgo) : InfoHallazgoDialogFragment {
            val fragment = InfoHallazgoDialogFragment()
            val args = Bundle()
            args.putInt(ARG_HALLAZGO_INDEX, hallazgoIndex)
            args.putSerializable(ARG_HALLAZGO_ITEM, hallazgo)
            fragment.arguments = args
            return fragment
        }

    }
    private var hallazgoIndex: Int = -1
    private lateinit var hallazgo: Hallazgo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hallazgoIndex = arguments?.getInt(ARG_HALLAZGO_INDEX) ?: -1
        hallazgo = ((arguments?.getSerializable(ARG_HALLAZGO_ITEM) ?: Hallazgo()) as Hallazgo)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info_hallazgo_dialog, container, false)
        val nombre = view.findViewById<TextView>(R.id.nombreHallazgoTextView)
        val cultura = view.findViewById<TextView>(R.id.culturaTextView)
        val epoca = view.findViewById<TextView>(R.id.epocaTextView)
        val descripcion = view.findViewById<TextView>(R.id.descripcionHallazgoTextView)
        val valor = view.findViewById<TextView>(R.id.valorHallazgoTextView)
        val imagen = view.findViewById<ImageView>(R.id.imagenHallazgoImageView)
        val vender = view.findViewById<CardView>(R.id.btnVender)
        val cancelar = view.findViewById<Button>(R.id.btnCancelar)

        nombre.text = hallazgo.nombre
        cultura.text = hallazgo.cultura.toString()
        epoca.text = hallazgo.epoca.toString()
        descripcion.text = hallazgo.descripcion
        valor.text = hallazgo.valor.toString()
        imagen.setImageResource(hallazgo.imagen)

        vender.setOnClickListener {
            Partida.jugador.vender(hallazgoIndex)
            dismiss()
        }
        cancelar.setOnClickListener {
            dismiss()
        }

        return view
    }


}