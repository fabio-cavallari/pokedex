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
){
    fun getTypeBySlot(slot: Int): Type {
        var requiredType = Type(0, TypeInfo("",""))
        types.forEach { type ->
            if (type.slot == slot)
                requiredType = Type(type.slot, TypeInfo(type.type.name, type.type.url))
        }

        return requiredType
    }

    fun asDomainModel(): Pokemon{
        var types = types
            .mapIndexed { index, type ->
                getTypeBySlot(index + 1).type.name
            }
        return Pokemon(name, order, types, sprites.frontDefault)
    }
}

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

