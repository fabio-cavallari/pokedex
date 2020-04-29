package com.pokedex.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.pokedex.R
import com.pokedex.adapter.PokemonListAdapter
import com.pokedex.models.Pokemon
import com.pokedex.view_model.HomeViewModel
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    private lateinit var mPokemonsList: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mPokemonsList = pokemons_list
        mPokemonsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        var pokemonListAdapter = PokemonListAdapter()
        mPokemonsList.adapter = pokemonListAdapter
        viewModel.pokemons.observe(this, Observer<List<Pokemon>> {
            pokemonListAdapter.submitList(it)
        })
        fab.setOnClickListener { view ->
            viewModel.addPokemon(Pokemon("Mewtwo"))
            Snackbar.make(view, "add pokemon", Snackbar.LENGTH_LONG)
                .show()
        }
        super.onViewCreated(view, savedInstanceState)

    }
}
