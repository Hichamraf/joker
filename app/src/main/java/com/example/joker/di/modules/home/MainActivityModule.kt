package com.example.joker.di.modules.home

import com.example.joker.ui.home.MainActivity
import com.example.joker.ui.home.jokes.JokeDetails
import com.example.joker.ui.home.jokes.JokesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun provideJokesFragment(): JokesFragment

    @ContributesAndroidInjector
    abstract fun provideJokesDetailFragment(): JokeDetails
}