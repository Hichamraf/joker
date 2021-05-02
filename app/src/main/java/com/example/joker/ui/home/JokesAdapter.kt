package com.example.joker.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.joker.R
import com.example.joker.databinding.JokeItemBinding
import com.example.joker.model.Joke

class JokesAdapter(val onJokeClick: (Joke) -> Unit) :
    RecyclerView.Adapter<JokesAdapter.JokeItemViewHolder>() {
    private var jokes = ArrayList<Joke>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeItemViewHolder {
        val binding = DataBindingUtil.inflate<JokeItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.joke_item,
            parent,
            false
        )
        return JokeItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    fun updateJokes(newJokes: ArrayList<Joke>) {
        var lastCount = this.jokes.size
        this.jokes.addAll(ArrayList(newJokes))
        notifyItemRangeInserted(lastCount, newJokes.size)
    }

    override fun onBindViewHolder(holder: JokeItemViewHolder, position: Int) {
        holder.binding.joke = jokes[position]
        holder.binding.arrowImg.setOnClickListener {  holder.itemView.callOnClick() }
        holder.itemView.setOnClickListener {
            onJokeClick(jokes[position])
        }
    }

    class JokeItemViewHolder(val binding: JokeItemBinding) : RecyclerView.ViewHolder(binding.root)
}

