package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.model.PokemonResponse

interface PokemonRepository {

    suspend fun getListPokemon(): PokemonResponse
}