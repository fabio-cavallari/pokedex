package com.pokedex.models.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties
data class PokemonNet (
    @JsonProperty("name") val name: String,
    @JsonProperty("type") val type: List<String>
)