package com.pokedex.paging

import androidx.paging.PageKeyedDataSource
import com.pokedex.models.Pokemon
import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonPage
import com.pokedex.models.network.PokemonResult
import com.pokedex.network.PokemonApiClient
import com.pokedex.network.PokemonApiService

class PokemonsDataSource(private val pokemonApiService: PokemonApiService): PageKeyedDataSource<Int, Pokemon>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Pokemon>) {
        val pokemons = mutableListOf<Pokemon>()
        pokemonApiService.fetchPokemonsList(0, params.requestedLoadSize)
            .subscribe({ response ->
                pokemons.add(response.asDomainModel())
            }, {e ->
                e.printStackTrace()
            }, {
                callback.onResult(pokemons, null, 1)
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Pokemon>) {
        val pokemons = mutableListOf<Pokemon>()
        pokemonApiService.fetchPokemonsList(params.key * params.requestedLoadSize, params.requestedLoadSize)
            .subscribe({response ->
                pokemons.add(response.asDomainModel())
            }, {e ->
                e.printStackTrace()
            }, {
                callback.onResult(pokemons, params.key + 1)
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Pokemon>) {

    }
}