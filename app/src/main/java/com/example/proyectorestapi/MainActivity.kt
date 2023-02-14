package com.example.proyectorestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.proyectorestapi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import www.iesmurgi.u9_proyprofesoressqlite.Product

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AlimentosAdapter
    private val alimentos = mutableListOf<Product>()
    var lista = mutableListOf<Alimento>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svAlimentos.setOnQueryTextListener(this)
        initRecyclerView()
        searchByName("04963406")
    }

    private fun initRecyclerView() {
        adapter = AlimentosAdapter(lista)
        binding.rvAlimentos.layoutManager = LinearLayoutManager(this)
        binding.rvAlimentos.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://world.openfoodfacts.org/api/v2/product/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getProductByCode("$query")
            val producto = call.body()
            println(producto)
            runOnUiThread {
                if(call.isSuccessful){
                    if (producto != null) {
                        lista.add(producto)
                    }
                    adapter.notifyDataSetChanged()
                }else{

                }
            }
        }


    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        println(query)
        if (!query.isNullOrEmpty()){
            searchByName(query.lowercase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

}

