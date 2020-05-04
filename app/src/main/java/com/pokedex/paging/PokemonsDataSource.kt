package com.pokedex.paging

import androidx.paging.PageKeyedDataSource
import com.pokedex.models.Pokemon
import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonPage
import com.pokedex.models.network.PokemonResult
import com.pokedex.network.PokemonApiClient
import com.pokedex.network.PokemonApiService

class PokemonsDataSource(private val pokemonApiService: PokemonApiService): PageKeyedDataSource<Int, Pokemon>() {
    fun PokemonListAsDomainModel(pokemonNetModelList: List<PokemonNetModel>): List<Pokemon>{
        return pokemonNetModelList.map { pokemonNetModel ->
            pokemonNetModel.asDomainModel()
        }
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Pokemon>) {
        pokemonApiService.fetchPokemonsList(0, params.requestedLoadSize)
            .subscribe({ response ->
                callback.onResult(PokemonListAsDomainModel(response), null, 1)
            }, {e -> e.printStackTrace()})
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Pokemon>) {
        pokemonApiService.fetchPokemonsList(params.key * params.requestedLoadSize, params.requestedLoadSize)
            .subscribe({response ->
                callback.onResult(PokemonListAsDomainModel(response), params.key + 1)
            }, {})
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Pokemon>) {

    }
}