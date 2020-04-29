package com.pokedex.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pokedex.models.Pokemon
import com.pokedex.models.network.PokemonIndex
import com.pokedex.network.PokemonApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel() {
    var pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData<List<Pokemon>>(listOf())
    var pokemonApiService: PokemonApiService = PokemonApiService()

    init {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        pokemonApiService.fetchPokemonsNames()
            ?.subscribeOn(Schedulers.io())
            ?.subscribe ({
                val fetchedList = mutableListOf<Pokemon>()
                it.results.forEach { pokemonIndex ->
                    fetchedList.add(pokemonIndex.asDomainModel())
                }
                pokemons.postValue(fetchedList)
            },  { e ->
                e.printStackTrace()
            })
    }


    fun addPokemon(pokemon: Pokemon) {
        var updatedPokemons = pokemons.value?.toMutableList()
        updatedPokemons?.add(pokemon)
        pokemons.postValue(updatedPokemons)
    }
}