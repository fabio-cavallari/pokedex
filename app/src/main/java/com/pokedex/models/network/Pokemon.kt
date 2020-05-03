package com.pokedex.models.network

import com.google.gson.annotations.SerializedName
import com.pokedex.models.Pokemon

data class PokemonPage(
    val results: List<PokemonResult>,
    val next: String?,
    val previous: String?
)

data class PokemonResult(
    val name: String,
    @SerializedName("url") val pokemonUrl: String

) {
    fun asDomainModel(): Pokemon {
        return Pokemon(name)
    }
}

data class PokemonNetModel(
    val name: String,
    val order: Int
)

