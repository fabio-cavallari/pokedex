package com.pokedex.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pokedex.models.Pokemon

class HomeViewModel: ViewModel() {
    private lateinit var pokemons: MutableLiveData<List<Pokemon>>

    init {
        val pokemonList = listOf<Pokemon>(Pokemon("Pikachu","eletric"), Pokemon("Charmander", "fire"))
        pokemons = MutableLiveData<List<Pokemon>>()
        pokemons.value = pokemonList
    }

    fun getPokemons(): LiveData<List<Pokemon>> {
        return pokemons
    }
}