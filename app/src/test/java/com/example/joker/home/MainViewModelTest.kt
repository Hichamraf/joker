package com.example.joker.home

import com.example.joker.data.JokesApi
import com.example.joker.model.Joke
import junit.framework.TestCase
import org.mockito.Mock

class MainViewModelTest : TestCase() {

    @Mock
    lateinit var jokesApi: JokesApi
    lateinit var viewModel: MainViewModel

    public override fun setUp() {
        super.setUp()
        viewModel = MainViewModel(jokesApi)
        val jokes = prepareTenJokes()
    }

    private fun prepareTenJokes(): ArrayList<Joke> {
      return arrayListOf(Joke(1,"test","test","test"))
    }

    public override fun tearDown() {}

    fun testListScrolled() {}
}