package com.example.proyectorestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.proyectorestapi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import www.iesmurgi.u9_proyprofesoressqlite.Alimentos
import www.iesmurgi.u9_proyprofesoressqlite.AlimentosAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AlimentosAdapter
    private val alimentos = mutableListOf<Alimentos>()
    var lista = mutableListOf<Alimentos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
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
            runOnUiThread {
                if(call.isSuccessful){
                    //show recyclerview
                }else{
                    //show error
                }
            }
        }


    }

}

