package com.pokedex.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pokedex.models.Pokemon

class HomeViewModel: ViewModel() {
    var pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData<List<Pokemon>>()

    init {
        val pokemonList = listOf<Pokemon>(Pokemon("Pikachu","eletric"), Pokemon("Charmander", "fire"))
        pokemons.value = pokemonList
    }

    fun getPokemons(): List<Pokemon>? {
        return pokemons.value
    }

    fun addPokemon(pokemon: Pokemon) {
        var updatedPokemons = pokemons.value?.toMutableList()
        updatedPokemons?.add(pokemon)
        pokemons.value = updatedPokemons
    }
}