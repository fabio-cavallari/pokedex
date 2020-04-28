package com.pokedex.models

class Pokemon (val name: String, val type:String){
    override fun equals(other: Any?): Boolean {
        if (other is Pokemon){
            return (other.name == name && other.type == type)
        }
        return false
    }
}