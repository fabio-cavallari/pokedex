package com.pokedex.models.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class PokemonResult (val results: List<PokemonIndex>)

data class PokemonIndex(
    val name: String,
    @SerializedName("url") val image: String
)