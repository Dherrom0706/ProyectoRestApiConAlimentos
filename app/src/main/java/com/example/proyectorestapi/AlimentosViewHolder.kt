package com.example.proyectorestapi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectorestapi.databinding.UsuariosEsqueletoBinding
import www.iesmurgi.u9_proyprofesoressqlite.Product

class AlimentosViewHolder (vista: View):RecyclerView.ViewHolder(vista){
  //  private val miBinding=UsuariosLayoutBinding.bind(vista)
    private val miBinding= UsuariosEsqueletoBinding.bind(vista)
    fun inflar(alimento: Alimento) {
        //miBinding.tvId.text=alimento._id
        //miBinding.tvNombre.text=alimento.product_name
        //miBinding.tvCalorias.text = alimento.kcal_100g.toString()
        var producto: Product = alimento.product
        var nutrientes: Nutriments = producto.nutriments
        miBinding.tvId.text = producto._id
        miBinding.tvNombre.text = producto.product_name
        miBinding.tvCalorias.text = nutrientes.kcal_100g.toString()


    }
}