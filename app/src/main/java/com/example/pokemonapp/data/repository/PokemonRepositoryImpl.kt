package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.api.ApiService
import com.example.pokemonapp.data.model.PokemonResponse
import com.example.pokemonapp.di.IoDispatcher
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PokemonRepository {

    override suspend fun getListPokemon(): ApiResponse<PokemonResponse> = withContext(ioDispatcher) {
        apiService.getListPokemon()
    }

}