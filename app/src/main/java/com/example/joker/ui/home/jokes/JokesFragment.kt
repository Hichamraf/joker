package com.example.joker.ui.home.jokes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.joker.R
import com.example.joker.databinding.ActivityMainBinding
import com.example.joker.databinding.JokesFragmentBinding
import com.example.joker.model.Resource
import com.example.joker.ui.home.JokesAdapter
import com.example.joker.ui.home.MainViewModel
import dagger.android.support.DaggerFragment
import hicham.com.bonialnews.di.viewmodel.ViewModelFactory
import javax.inject.Inject

class JokesFragment : DaggerFragment() {
    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: JokesFragmentBinding
    private val jokesAdapter by lazy { JokesAdapter{
        viewModel.selectedJoke=it
        binding.root.findNavController().navigate(R.id.action_jokesFragment_to_jokeDetails)
    } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.jokes_fragment,container,false)
        viewModel = ViewModelProvider(requireActivity(), factory).get(MainViewModel::class.java)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        binding.jokesRecycler.layoutManager= LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false)
        binding.jokesRecycler.adapter =jokesAdapter
        viewModel.jokesLiveData.observe(this, Observer {
            if (it.status == Resource.Status.SUCCESS && !it.data.isNullOrEmpty()) {
                jokesAdapter.updateJokes(ArrayList(it.data.toMutableList()))
            }

        })
        val layoutManager=binding.jokesRecycler.layoutManager as LinearLayoutManager
        binding.jokesRecycler.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                viewModel.listScrolled(layoutManager.childCount, layoutManager.findLastVisibleItemPosition(),  layoutManager.itemCount)
            }
        })
        return binding.root
    }


}