package com.example.joker.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.joker.R
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import hicham.com.bonialnews.di.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var factory : ViewModelFactory

    lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this,factory).get(MainViewModel::class.java)
        viewModel.jokesLiveData.observe(this, Observer {
            var list=it
        })
    }
}