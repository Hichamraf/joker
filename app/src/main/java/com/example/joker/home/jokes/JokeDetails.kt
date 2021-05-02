package com.example.joker.home.jokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.joker.R
import com.example.joker.databinding.FragmentJokeDetailsBinding
import com.example.joker.home.MainViewModel
import dagger.android.support.DaggerFragment
import hicham.com.bonialnews.di.viewmodel.ViewModelFactory
import javax.inject.Inject


class JokeDetails : DaggerFragment() {
    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentJokeDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_joke_details,container,false)
        viewModel = ViewModelProvider(requireActivity(), factory).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
        binding.joke=viewModel.selectedJoke
        binding.imageUrl="https://picsum.photos/200/300?grayscale"
        return binding.root
    }

}