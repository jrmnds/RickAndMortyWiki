package com.jrmnds.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jrmnds.rickandmorty.data.api.RetrofitInstance
import com.jrmnds.rickandmorty.data.api.RickAndMortyService
import com.jrmnds.rickandmorty.databinding.ActivityMainBinding
import com.jrmnds.rickandmorty.domain.model.PaginationResults
import com.jrmnds.rickandmorty.ui.RickAndMortyAdapter
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val rickAndMortyService = RetrofitInstance.getRetrofitInstance().create(RickAndMortyService::class.java)
    var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        testRequest()
    }
    private fun testRequest(){
        val responseLiveData: LiveData<Response<PaginationResults>> = liveData {
            val response = rickAndMortyService.getAllCharacters()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val paginationResults = it.body()
            val adapter = RickAndMortyAdapter(paginationResults?.results!!)
            binding?.recycleViewId?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding?.recycleViewId?.adapter = adapter
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}