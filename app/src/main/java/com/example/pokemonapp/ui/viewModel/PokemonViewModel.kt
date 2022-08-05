package com.example.pokemonapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.data.model.PokemonResponse
import com.example.pokemonapp.data.repository.PokemonRepository
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val pokemonRepository: PokemonRepository):ViewModel() {

    //Encapsulation
    private val _listPokemon = MutableLiveData<PokemonResponse>()
    val listPokemon: LiveData<PokemonResponse>
    get()=_listPokemon

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
    get() = _error

    fun getListPokemon(){
        viewModelScope.launch {
            pokemonRepository.getListPokemon()
                .onSuccess {
                    _listPokemon.postValue(response.body())
                }.onError {
                    _error.postValue(response.errorBody()?.string())
                }.onFailure {

                }
        }
    }
}