package com.pokedex.paging

import androidx.paging.PageKeyedDataSource
import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonPage
import com.pokedex.models.network.PokemonResult
import com.pokedex.network.PokemonApiClient
import com.pokedex.network.PokemonApiService

class PokemonsDataSource(private val pokemonApiService: PokemonApiService): PageKeyedDataSource<Int, PokemonNetModel>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PokemonNetModel>) {
        pokemonApiService.fetchPokemonsList(0, params.requestedLoadSize)
            .subscribe({ response ->
                callback.onResult(response, null, 1)
            }, {e -> e.printStackTrace()})
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PokemonNetModel>) {
        pokemonApiService.fetchPokemonsList(params.key * params.requestedLoadSize, params.requestedLoadSize)
            .subscribe({response ->
                callback.onResult(response, params.key + 1)
            }, {})
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PokemonNetModel>) {

    }
}