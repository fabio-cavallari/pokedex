package com.pokedex.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.pokedex.models.Pokemon
import com.pokedex.models.State
import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonPage
import com.pokedex.models.network.PokemonResult
import com.pokedex.network.PokemonApiClient
import com.pokedex.network.PokemonApiService

class PokemonsDataSource(private val pokemonApiService: PokemonApiService): PageKeyedDataSource<Int, Pokemon>() {

    var state: MutableLiveData<State> = MutableLiveData()

    private fun updateState(state: State) {
        this.state.postValue(state)
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Pokemon>) {
        updateState(State.LOADING)
        val pokemons = mutableListOf<Pokemon>()
        pokemonApiService.fetchPokemonsList(0, params.requestedLoadSize)
            .subscribe({ response ->
                pokemons.add(response.asDomainModel())
            }, {e ->
                e.printStackTrace()
                updateState(State.ERROR)
            }, {
                callback.onResult(pokemons, null, 1)
                updateState(State.DONE)
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Pokemon>) {
        updateState(State.LOADING)
        val pokemons = mutableListOf<Pokemon>()
        pokemonApiService.fetchPokemonsList(params.key * params.requestedLoadSize, params.requestedLoadSize)
            .subscribe({response ->
                pokemons.add(response.asDomainModel())
            }, {e ->
                e.printStackTrace()
                updateState(State.ERROR)
            }, {
                callback.onResult(pokemons, params.key + 1)
                updateState(State.DONE)
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Pokemon>) {

    }
}