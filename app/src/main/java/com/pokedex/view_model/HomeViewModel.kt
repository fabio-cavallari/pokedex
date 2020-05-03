package com.pokedex.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.pokedex.models.Pokemon
import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonResult
import com.pokedex.network.PokemonApiService
import com.pokedex.paging.PokemonDataSourceFactory
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel() {
    var pokemonList: LiveData<PagedList<PokemonNetModel>>
    private val pokemonApiService: PokemonApiService = PokemonApiService()
    private val pageSize = 10
    private val pokemonsDataSourceFactory: PokemonDataSourceFactory

    init {
        pokemonsDataSourceFactory = PokemonDataSourceFactory(pokemonApiService)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize)
            .setEnablePlaceholders(false)
            .build()
        pokemonList = LivePagedListBuilder<Int, PokemonNetModel>(pokemonsDataSourceFactory, config).build()
    }

//    private fun fetchPokemons() {
//
//        pokemonApiService.fetchPokemonsNames()
//            .subscribeOn(Schedulers.io())
//            .subscribe ({
//                val fetchedList = mutableListOf<Pokemon>()
//                it.results.forEach { pokemonIndex ->
//                    fetchedList.add(pokemonIndex.asDomainModel())
//                }
//                pokemonList.postValue(fetchedList)
//            },  { e ->
//                e.printStackTrace()
//            })
//    }


//    fun addPokemon(pokemon: Pokemon) {
//        var updatedPokemons = pokemonList.value?.toMutableList()
//        updatedPokemons?.add(pokemon)
//        pokemons.postValue(updatedPokemons)
//    }
}