package com.tsse.spain.marvelapptalentomobile.ui.characters_landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsse.spain.marvelapptalentomobile.databinding.CharacterItemBinding
import com.tsse.spain.marvelapptalentomobile.utils.DateUtil.toDDMMYYYYString
import com.tsse.spain.marvelapptalentomobile.utils.setImgFromUri


/**
Created By Diego Garzón on 09/08/2021
 */
class CharacterAdapter(
    private val characterViewModelList: List<CharacterDataViewModel.Character>?,
    private val navigateToCharacterFragment: (String) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private lateinit var binding: CharacterItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return characterViewModelList?.size ?: 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val model = characterViewModelList?.get(position)
        binding.ivShowCharacter.setOnClickListener { navigateToCharacterFragment(model?.id.toString()) }

        binding.tvCharacterName.text = model?.name
        binding.tvCharacterDate.text = model?.modified?.toDDMMYYYYString()
        model?.description?.let {
            binding.tvCharacterDescription.text = it
        } ?: run {
            binding.tvCharacterDescription.visibility = View.GONE
            binding.separator.visibility = View.GONE
        }
        val url = String.format("%s.%s", model?.thumbnail?.path, model?.thumbnail?.extension)
        setImgFromUri(binding.ivCharacterPhoto, url)
    }

    inner class CharacterViewHolder(binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}