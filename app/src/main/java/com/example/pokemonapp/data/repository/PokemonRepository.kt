package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.model.Pokemon
import com.example.pokemonapp.data.model.PokemonResponse
import com.skydoves.sandwich.ApiResponse

interface PokemonRepository {

    suspend fun getListPokemon(): ApiResponse<PokemonResponse>
}