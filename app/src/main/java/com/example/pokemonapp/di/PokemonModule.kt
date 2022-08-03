package com.example.pokemonapp.di

import com.example.pokemonapp.data.repository.PokemonRepository
import com.example.pokemonapp.data.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonModule {

    @Singleton
    @Provides
    fun providesLisPokemon(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository = pokemonRepositoryImpl
}