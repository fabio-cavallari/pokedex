package com.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pokedex.R
import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonResult
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class PokemonListAdapter() : PagedListAdapter<PokemonNetModel, PokemonListAdapter.ViewHolder>(PokemonListAdapter.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(pokemon: PokemonNetModel?) {
            val name = itemView.pokemon_name
            name.text = pokemon?.name
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<PokemonNetModel>() {
        override fun areItemsTheSame(oldItem: PokemonNetModel, newItem: PokemonNetModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: PokemonNetModel, newItem: PokemonNetModel): Boolean {
            return oldItem == newItem
        }

    }
}

