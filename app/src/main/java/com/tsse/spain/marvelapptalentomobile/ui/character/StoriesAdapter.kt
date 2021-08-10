package com.tsse.spain.marvelapptalentomobile.ui.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsse.spain.marvelapptalentomobile.databinding.StoryItemBinding
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharacterDataViewModel


/**
Created By Diego Garzón on 09/08/2021
 */
class StoriesAdapter(
    private val storiesList: List<CharacterDataViewModel.StorySummary>?
) :
    RecyclerView.Adapter<StoriesAdapter.StoryViewHolder>() {

    private lateinit var binding: StoryItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        binding = StoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return storiesList?.size ?: 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val model = storiesList?.get(position)

        binding.tvStoryName.text = model?.name
        binding.tvStoryUri.text = model?.resourceURI
    }

    inner class StoryViewHolder(binding: StoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}