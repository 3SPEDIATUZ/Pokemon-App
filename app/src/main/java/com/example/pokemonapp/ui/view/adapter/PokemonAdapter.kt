package com.example.pokemonapp.ui.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.ImageRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokemonapp.R
import com.example.pokemonapp.data.model.Pokemon

import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.utils.Constants.IMAGE_URL

class PokemonAdapter (private val onClickListener: OnClickListener): RecyclerView.Adapter<PokemonAdapter.MainViewHolder>() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var context: Context
    private var pokemonModels: List<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_pokemon, parent, false)
        return MainViewHolder (view)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = pokemonModels[position]
        with(holder){
            holder.bind(item)
            val id : List<String> =item.link.split("/")
            //Log.e("valor","$IMAGE_URL${id[id.size-1]}.png");
            //Log.e("valior","${id[id.size-1]}");
            Log.e("xxx","${id.get(6)}")

            Glide.with(context)
                .load("$IMAGE_URL${id.get(6)}.png")
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_baseline_error_24)
                .into(holder.itemPokemonBinding.imageViewPokemon)

            itemPokemonBinding.textViewPokemon.text = item.name
        }

    }

    override fun getItemCount(): Int  = pokemonModels.size

    inner class  MainViewHolder (view: View): RecyclerView.ViewHolder(view){
        val itemPokemonBinding = ItemPokemonBinding.bind(view)
        fun bind(pokemon: Pokemon){
            itemPokemonBinding.root.setOnClickListener {
                onClickListener.onClick(pokemon)
            }
        }
    }

     fun submitList(item: List<Pokemon>) {
        pokemonModels = item
        notifyItemInserted(pokemonModels.size - 1)
    }

    interface OnClickListener{
        fun onClick (data : Pokemon)
    }
}