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

)

data class PokemonNetModel(
    val name: String,
    val order: Int,
    val sprites: Sprite,
    val types: List<Type>
)

data class Sprite(
    @SerializedName("front_default") val frontDefault: String
)

data class Type(
    val slot: Int,
    val type: TypeInfo
)

data class TypeInfo(
    val name: String,
    val url: String
)

