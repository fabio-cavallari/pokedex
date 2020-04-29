package com.pokedex.models

class Pokemon (val name: String){
    override fun equals(other: Any?): Boolean {
        if (other is Pokemon){
            return (other.name == name)
        }
        return false
    }
}