package com.example.joker.di.modules.home

import com.example.joker.ui.home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun provideMainActivity() : MainActivity
}