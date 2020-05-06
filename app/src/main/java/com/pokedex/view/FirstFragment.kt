package com.pokedex.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
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
    private lateinit var mLayoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mPokemonsList = pokemons_list
        mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mPokemonsList.layoutManager = mLayoutManager
        mPokemonsList.addItemDecoration(DividerItemDecoration(context,mLayoutManager.orientation ))
        val viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        var pokemonListAdapter = PokemonListAdapter()
        mPokemonsList.adapter = pokemonListAdapter
        viewModel.pokemonList.observe(this, Observer {
            pokemonListAdapter.submitList(it)
        })

        super.onViewCreated(view, savedInstanceState)

    }
}
