package com.pokedex.paging

import androidx.paging.PageKeyedDataSource
import com.pokedex.models.network.PokemonPage
import com.pokedex.models.network.PokemonResult
import com.pokedex.network.PokemonApiClient
import com.pokedex.network.PokemonApiService

class PokemonsDataSource(private val pokemonApiService: PokemonApiService): PageKeyedDataSource<Int, PokemonResult>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PokemonResult>) {
        pokemonApiService.fetchPokemonsNames(0, params.requestedLoadSize)
            .subscribe({ response ->
                callback.onResult(response.results, null, 1)
            }, {e -> e.printStackTrace()})
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PokemonResult>) {
        pokemonApiService.fetchPokemonsNames(params.key * params.requestedLoadSize, params.requestedLoadSize)
            .subscribe({response ->
                callback.onResult(response.results, params.key + 1)
            }, {})
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PokemonResult>) {

    }

//    override fun loadInitial(
//        params: LoadInitialParams<String>,
//        callback: LoadInitialCallback<String, PokemonResult>
//    ) {
//        pokemonApiService.fetchPokemonsNames()
//            .subscribe({ response ->
//                callback.onResult(response.results, response.next, response.previous)
//            }, {e -> e.printStackTrace()})
//
//    }
//
//    override fun loadAfter(
//        params: LoadParams<String>,
//        callback: LoadCallback<String, PokemonResult>
//    ) {
//        pokemonApiService.fetchPokemonsNames()
//            .subscribe({ response ->
//                callback.onResult(response.results, response.next)
//            },{e -> e.printStackTrace()})
//    }
//
//    override fun loadBefore(
//        params: LoadParams<String>,
//        callback: LoadCallback<String, PokemonResult>
//    ) {
//    }
}