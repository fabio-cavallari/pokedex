package com.pokedex.models

class Pokemon (
    val name: String,
    val oder: Int,
    val type: List<String>,
    val icon: String
    ){
    override fun equals(other: Any?): Boolean {
        if (other is Pokemon){
            return (other.name == name)
        }
        return false
    }
}