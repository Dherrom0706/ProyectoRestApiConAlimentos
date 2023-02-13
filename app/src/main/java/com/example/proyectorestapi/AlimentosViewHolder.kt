package com.example.proyectorestapi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectorestapi.databinding.UsuariosEsqueletoBinding
import www.iesmurgi.u9_proyprofesoressqlite.Alimentos

class AlimentosViewHolder (vista: View):RecyclerView.ViewHolder(vista){
  //  private val miBinding=UsuariosLayoutBinding.bind(vista)
    private val miBinding= UsuariosEsqueletoBinding.bind(vista)
    fun inflar(alimento: Alimentos) {
        miBinding.tvId.text=alimento.code
        miBinding.tvNombre.text=alimento.product_name
    }
}