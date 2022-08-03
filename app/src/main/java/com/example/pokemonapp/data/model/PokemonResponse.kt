package com.example.pokemonapp.data.model

import com.example.pokemonapp.data.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("results") val response: List<Pokemon>
)
