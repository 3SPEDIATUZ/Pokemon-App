package com.example.pokemonapp.data.api

import com.example.pokemonapp.data.model.PokemonResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("pokemon")
    suspend fun getListPokemon(): ApiResponse<PokemonResponse>
}