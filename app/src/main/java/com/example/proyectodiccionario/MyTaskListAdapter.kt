package com.example.proyectodiccionario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MyTaskListAdapter (context: AppCompatActivity,
                         val info: Bundle): RecyclerView.Adapter<MyTaskListAdapter.MyViewHolder>(){
    class MyViewHolder (val layout: View): RecyclerView.ViewHolder(layout)
    private  var context: AppCompatActivity = context

    var myTaskTitles: ArrayList<String> = info.getStringArrayList("palabraFav") as ArrayList<String>
    var myTaskTraslate: ArrayList<String> = info.getStringArrayList("palabraTrad") as ArrayList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.task_list_items, parent,false)

        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var textViewTask = holder.layout.findViewById<TextView>(R.id.txtListFavP)
        textViewTask.text = myTaskTitles[position]
        var textViewTraslate = holder.layout.findViewById<TextView>(R.id.txtListFavS)
        textViewTraslate.text = myTaskTraslate[position]
    }

    override fun getItemCount(): Int {
        return myTaskTitles.size
    }
}