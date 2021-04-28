package com.example.joker.ui

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import hicham.com.bonialnews.di.DaggerAppComponent

class BaseApplication  : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}