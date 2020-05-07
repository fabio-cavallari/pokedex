package com.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pokedex.R
import com.pokedex.custom_views.TypeView
import com.pokedex.models.Pokemon
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
            val types: LinearLayoutCompat = itemView.types
            val image = itemView.pokemon_image
            val name = itemView.pokemon_name
            name.text = pokemon?.name?.capitalize()
            Glide
                .with(itemView.context)
                .load(pokemon?.icon)
                .placeholder(R.drawable.pokeball2)
                .fitCenter()
                .into(image);
            setTypes(types, pokemon)
        }

        fun setTypes(typesView: LinearLayoutCompat, pokemon: Pokemon?) {
            typesView.removeAllViews()
            pokemon?.type?.forEach { type ->
                typesView.addView(TypeView(typesView.context, type))
            }
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

