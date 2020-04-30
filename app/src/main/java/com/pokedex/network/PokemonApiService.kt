package com.pokedex.network

import com.google.gson.GsonBuilder
import com.pokedex.models.network.PokemonPage
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PokemonApiService {
    val client: PokemonApiClient

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()

        client = retrofit.create<PokemonApiClient>(PokemonApiClient::class.java)
    }

    fun fetchPokemonsNames(offset: Int, limit: Int): Observable<PokemonPage> {
        return client.getPokemonsNames(offset, limit)
    }
}