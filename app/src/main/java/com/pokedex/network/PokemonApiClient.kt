package com.pokedex.network

import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiClient {
    @GET("pokemon")
    fun getPokemonsNames(): Observable<PokemonResult>

    @GET("pokemon/{name}")
    fun getPokemonName(@Path("name") name: String): Observable<PokemonNetModel>
}