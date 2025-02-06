package com.example.ancientdiggers.ui.elements.mainfragments.dialogfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.ancientdiggers.R
import com.example.ancientdiggers.data.model.hallazgo.Hallazgo


class InfoHallazgoDialogFragment : DialogFragment() {

    companion object {
        private const val ARG_HALLAZGO_INDEX = "hallazgo_index"
        private const val ARG_HALLAZGO_ITEM = "hallazgo_item"

        fun newInstance(hallazgoIndex: Int) : InfoHallazgoDialogFragment {
            val fragment = InfoHallazgoDialogFragment()
            val args = Bundle()
            args.putInt(ARG_HALLAZGO_INDEX, hallazgoIndex)
            fragment.arguments = args
            return fragment
        }

    }
    private var hallazgoIndex: Int = -1
    private var hallazgo: Hallazgo = Hallazgo.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hallazgoIndex = arguments?.getInt(ARG_HALLAZGO_INDEX) ?: -1
        hallazgo = (arguments?.getSerializable(ARG_HALLAZGO_ITEM) ?: Hallazgo.newInstance()) as Hallazgo
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info_hallazgo_dialog, container, false)

        return view
    }


}