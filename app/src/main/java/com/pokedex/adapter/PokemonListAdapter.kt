package com.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pokedex.R
import com.pokedex.models.Pokemon
import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonResult
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class PokemonListAdapter() : PagedListAdapter<Pokemon, PokemonListAdapter.ViewHolder>(PokemonListAdapter.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(pokemon: Pokemon?) {
            val image = itemView.pokemon_image
            val name = itemView.pokemon_name
            name.text = pokemon?.name?.capitalize()
            Glide
                .with(itemView.context)
                .load(pokemon?.icon)
                .centerCrop()
                .placeholder(R.drawable.pokeball)
                .into(image);
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }

    }
}

