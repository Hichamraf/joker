package com.example.joker.ui.home

import androidx.lifecycle.*
import com.example.joker.data.JokesApi
import com.example.joker.model.Joke
import com.example.joker.model.Resource
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(private val jokesApi: JokesApi) : ViewModel() {


    private val _jokesLiveData = MutableLiveData<Resource<List<Joke>?>>()
    val jokesLiveData=_jokesLiveData
    private var isLoading=false
    lateinit var selectedJoke: Joke
    init {
        loadJokes()
    }


    private fun loadJokes(){
        isLoading=true
    viewModelScope.launch {
        _jokesLiveData.postValue(Resource.loading())
        try {
            val jokes = jokesApi.getJokes()
            _jokesLiveData.postValue(Resource.success(jokes))
        } catch (ex: Exception) {
            _jokesLiveData.postValue(Resource.error(ex.message.toString()))
        }
        isLoading=false
    }
    }


    fun listScrolled(visibleItemCount: Int, lastVisibleItem: Int, totalItemCount: Int) {
        if (visibleItemCount + lastVisibleItem >= totalItemCount  && !isLoading) {
            loadJokes()
        }
    }

    companion object {
        private const val VISIBLE_THRESHOLD = 1
    }

}