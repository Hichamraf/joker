package com.example.joker.model

data class Joke(val id: Int, val type: String, val setup: String, val punchline: String){
    override fun equals(other: Any?): Boolean {
        if(other !is Joke){
           return false
        }else{
            if(this.id== other.id)
            {
                return true
            }
        }
        return false
    }
}