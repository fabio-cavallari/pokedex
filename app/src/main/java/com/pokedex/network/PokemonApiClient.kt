package com.pokedex.network

import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonPage
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiClient {
    @GET("pokemon")
    fun getPokemonsNames(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<PokemonPage>

    @GET("pokemon/{name}")
    fun getPokemonName(@Path("name") name: String): Observable<PokemonNetModel>
}