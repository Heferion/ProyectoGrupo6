package com.example.proyectodiccionario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class ToDoFragment : Fragment(){
    private lateinit var listRecyclerView: RecyclerView
    private lateinit var myAdapter: RecyclerView.Adapter<MyTaskListAdapter.MyViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragment_to_do, container, false)
//        var favorita = requireArguments().getString("txtListFavP")
//        var traduccion = requireArguments().getString("txtListFavS")
//
//        var textViewFavorita: TextView = fragmento.findViewById(R.id.txtListFavP)
//        var textViewTraduccion: TextView = fragmento.findViewById(R.id.txtListFavS)

//        textViewFavorita.text = favorita
//        textViewTraduccion.text = traduccion

//        val detail: ImageView = fragmento.findViewById(R.id.imgListFav)

//        detail.setOnClickListener(View.OnClickListener {
//
//            val datos = Bundle()
//            datos.putString("txtFavorita", "Árbol")
//            datos.putString("txtTraduccion","Tree")
//            activity?.getSupportFragmentManager()?.beginTransaction()
//                ?.setReorderingAllowed(true)
//                ?.replace(R.id.fragment_container_view, DetailFragment::class.java, datos, "detail")
//                ?.addToBackStack("")
//                ?.commit()
//        })

        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var taskFavoritos: ArrayList<String> = ArrayList()
        taskFavoritos.add("Árbol")

        var taskTraduccion: ArrayList<String> = ArrayList()
        taskTraduccion.add("Tree")

        var info: Bundle = Bundle()
        info.putStringArrayList("palabraFav",taskFavoritos)
        info.putStringArrayList("palabraTrad",taskTraduccion)

        listRecyclerView = requireView().findViewById(R.id.recyclerTodoList)
        myAdapter = MyTaskListAdapter(activity as AppCompatActivity,info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

    }
}