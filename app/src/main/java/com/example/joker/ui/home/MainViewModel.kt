package com.example.joker.ui.home

import androidx.lifecycle.*
import com.example.joker.data.JokesApi
import com.example.joker.model.Joke
import com.example.joker.model.Resource
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(private val jokesApi: JokesApi) : ViewModel() {


    private val _jokesLiveData = MutableLiveData<Resource<ArrayList<Joke>?>>()
    val jokesLiveData = _jokesLiveData
    private var allJokes = arrayListOf<Joke>()
    private var isLoading = false
    lateinit var selectedJoke: Joke

    init {
        loadJokes()
    }


    private fun loadJokes() {
        isLoading = true
        viewModelScope.launch {
            _jokesLiveData.postValue(Resource.loading())
            try {
                val jokes = jokesApi.getJokes()
                allJokes.addAll(jokes)
                val uniqueJokes = eliminateRedondantJokes(jokes)
                _jokesLiveData.postValue(Resource.success(ArrayList(uniqueJokes)))
            } catch (ex: Exception) {
                _jokesLiveData.postValue(Resource.error(ex.message.toString()))
            }
            isLoading = false
        }
    }

    private fun eliminateRedondantJokes(jokes: ArrayList<Joke>): List<Joke> {
        return jokes.filter { allJokes.contains(it) }
    }


    fun listScrolled(visibleItemCount: Int, lastVisibleItem: Int, totalItemCount: Int) {
        if (visibleItemCount + lastVisibleItem + VISIBLE_THRESHOLD >= totalItemCount && !isLoading) {
            loadJokes()
        }
    }

    fun tryAgain(){
        loadJokes()
    }

    companion object {
        private const val VISIBLE_THRESHOLD = 1
    }

}