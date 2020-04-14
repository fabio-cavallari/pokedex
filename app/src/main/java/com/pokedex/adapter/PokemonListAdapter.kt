package com.pokedex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.pokedex.R
import com.pokedex.models.Pokemon
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class PokemonListAdapter() : Adapter<PokemonListAdapter.ViewHolder>() {

    private lateinit var pokemons: List<Pokemon>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bindView(pokemon)
    }

    fun setPokemons(pokemons: List<Pokemon>) {
        this.pokemons = pokemons
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(pokemon: Pokemon) {
            val type = itemView.pokemon_type
            val name = itemView.pokemon_name
            name.text = pokemon.name
            type.text = pokemon.type
        }
    }
}

