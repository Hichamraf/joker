package com.example.joker.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.joker.data.JokesApi
import javax.inject.Inject

class MainViewModel  @Inject constructor(val jokesApi: JokesApi): ViewModel() {

    val jokesLiveData= liveData {
        emit(jokesApi.getJokes())
    }

}