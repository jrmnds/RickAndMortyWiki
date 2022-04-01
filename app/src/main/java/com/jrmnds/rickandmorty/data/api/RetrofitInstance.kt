package com.jrmnds.rickandmorty.data.api

import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import com.jrmnds.rickandmorty.configuration.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{

        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}