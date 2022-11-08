package com.example.proyectodiccionario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragment_detail, container, false)

        var favorita = requireArguments().getString("txtFavorita")
        var traduccion = requireArguments().getString("txtTraduccion")


        var textViewFavorita: TextView = fragmento.findViewById(R.id.txtDetailFav)
        var textViewTraduccion: TextView = fragmento.findViewById(R.id.txtDetailTrasl)

        textViewFavorita.text = favorita
        textViewTraduccion.text = traduccion


        return fragmento
    }
}
































