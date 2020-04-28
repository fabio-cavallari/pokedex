package com.pokedex.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pokedex.models.Pokemon
import com.pokedex.models.network.PokemonIndex
import com.pokedex.network.PokemonApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel() {
    var pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData<List<Pokemon>>()
    var pokemonApiService: PokemonApiService = PokemonApiService()
    var pokemonNamesList: List<PokemonIndex> = listOf()

    init {
        val pokemonList = listOf<Pokemon>(Pokemon("Pikachu","eletric"), Pokemon("Charmander", "fire"))
        pokemons.value = pokemonList
        fetchPokemons()

    }

    fun fetchPokemons() {
        pokemonApiService.fetchPokemonsNames()
            ?.subscribeOn(Schedulers.io())
            ?.subscribe ({
                pokemonNamesList = it.results
            },  { e ->
                e.printStackTrace()
            })
    }


    fun addPokemon(pokemon: Pokemon) {
        var updatedPokemons = pokemons.value?.toMutableList()
        updatedPokemons?.add(pokemon)
        pokemons.value = updatedPokemons
    }
}