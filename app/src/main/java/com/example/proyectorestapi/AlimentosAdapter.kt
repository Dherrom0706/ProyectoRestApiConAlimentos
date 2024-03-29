package com.example.proyectorestapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import www.iesmurgi.u9_proyprofesoressqlite.Product

class AlimentosAdapter(
    private val lista: MutableList<Alimento>
):RecyclerView.Adapter<AlimentosViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlimentosViewHolder { //2.
        val v=LayoutInflater.from(parent.context).inflate(R.layout.usuarios_esqueleto,parent,false)
        return AlimentosViewHolder(v)
    }

    override fun onBindViewHolder(holder: AlimentosViewHolder, position: Int) {
        val item = lista[position]
        holder.inflar(item)
    }

    override fun getItemCount()=lista.size  //1

}
