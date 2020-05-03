package com.pokedex.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonResult
import com.pokedex.network.PokemonApiService

class PokemonDataSourceFactory(private val pokemonApiService: PokemonApiService): DataSource.Factory<Int, PokemonNetModel>() {
    val pokemonPageLiveData = MutableLiveData<PokemonsDataSource>()
    override fun create(): DataSource<Int, PokemonNetModel> {
        val pokemonDataSource = PokemonsDataSource(pokemonApiService)
        pokemonPageLiveData.postValue(pokemonDataSource)
        return pokemonDataSource
    }

}