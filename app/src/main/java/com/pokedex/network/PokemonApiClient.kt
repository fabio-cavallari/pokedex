package com.pokedex.network

import com.pokedex.models.network.PokemonNetModel
import com.pokedex.models.network.PokemonPage
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonApiClient {
    @GET("pokemon")
    fun getPokemonsPage(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<PokemonPage>

    @GET
    fun getPokemonByUrl(@Url url: String): Observable<PokemonNetModel>
}
