package com.pokedex.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.pokedex.models.Pokemon
import com.pokedex.models.State
import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonResult
import com.pokedex.network.PokemonApiService
import com.pokedex.paging.PokemonDataSourceFactory
import com.pokedex.paging.PokemonsDataSource
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel() {
    var pokemonList: LiveData<PagedList<Pokemon>>
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
        pokemonList = LivePagedListBuilder<Int, Pokemon>(pokemonsDataSourceFactory, config).build()
    }
    
}