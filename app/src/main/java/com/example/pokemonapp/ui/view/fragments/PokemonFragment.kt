package com.example.pokemonapp.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonapp.R
import com.example.pokemonapp.data.model.Pokemon
import com.example.pokemonapp.databinding.FragmentPokemonBinding
import com.example.pokemonapp.ui.view.adapter.PokemonAdapter
import com.example.pokemonapp.ui.viewModel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonFragment : Fragment(), PokemonAdapter.OnClickListener {

    private lateinit var binding: FragmentPokemonBinding
    private lateinit var pokemonAdapter: PokemonAdapter

    private val pokemonViewModel : PokemonViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPokemonBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        pokemonViewModel.getListPokemon()
        setObserver()
    }

    private fun setAdapter() {
        pokemonAdapter = PokemonAdapter(this)
        binding.recyclerViewPokemon.adapter = pokemonAdapter
        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerViewPokemon.layoutManager = layoutManager

    }

    private fun setObserver(){
        pokemonViewModel.listPokemon.observe(viewLifecycleOwner, { listPokemon ->
           pokemonAdapter.submitList(listPokemon.response)
        })
    }

    override fun onClick(data: Pokemon) {
        TODO("Not yet implemented")
    }


}