package com.example.joker.di.modules


import com.example.joker.data.JokesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideJokesApi(retrofit: Retrofit) = retrofit.create(JokesApi::class.java)
}