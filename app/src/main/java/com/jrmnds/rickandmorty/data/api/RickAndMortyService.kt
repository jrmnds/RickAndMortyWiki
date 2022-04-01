package com.jrmnds.rickandmorty.data.api

import com.jrmnds.rickandmorty.domain.model.PaginationResults
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyService {

    @GET("character")
   suspend fun getAllCharacters() : Response<PaginationResults>

}