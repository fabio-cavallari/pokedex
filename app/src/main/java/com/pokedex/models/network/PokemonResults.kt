package com.pokedex.models.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import com.pokedex.models.Pokemon

data class PokemonResult (val results: List<PokemonIndex>)

data class PokemonIndex(
    val name: String,
    @SerializedName("url") val image: String
) {
    fun asDomainModel(): Pokemon {
        return Pokemon(name)
    }
}

data class PokemonNetModel(
    val name: String,
    val type: List<String>
)

