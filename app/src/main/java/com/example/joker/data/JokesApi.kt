package com.example.joker.data

import com.example.joker.model.Joke
import retrofit2.http.GET

interface JokesApi {

@GET("random_ten")
suspend fun getJokes() : ArrayList<Joke>
}