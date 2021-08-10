package com.tsse.spain.marvelapptalentomobile.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsse.spain.marvelapptalentomobile.R
import com.tsse.spain.marvelapptalentomobile.databinding.CharacterFragmentBinding
import com.tsse.spain.marvelapptalentomobile.platform.Status
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharacterAdapter
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharacterDataViewModel
import com.tsse.spain.marvelapptalentomobile.utils.setImgFromUri
import org.koin.android.viewmodel.ext.android.getViewModel
import java.util.ArrayList

class CharacterFragment : Fragment() {
    private var _binding: CharacterFragmentBinding? = null
    private val binding get() = _binding!!
    private val args: CharacterFragmentArgs by navArgs()
    private lateinit var characterId: String

    private lateinit var viewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CharacterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterId = args.characterId
        viewModel = getViewModel(CharacterViewModel::class)
        viewModel.listCharacters.observe(requireActivity(), { charactersData ->
            when (charactersData.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    showErrorMessage(charactersData.exception?.message!!)
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    setCharacter(charactersData.data?.results)
                    setStoriesAdapter(charactersData.data?.results?.first()?.stories)
                }
            }
        })
        viewModel.load(characterId)
    }

    private fun setStoriesAdapter(stories: CharacterDataViewModel.StoryList?) {
        binding.rvStories.layoutManager = LinearLayoutManager(requireContext())
        binding.rvStories.adapter =
            StoriesAdapter(stories?.items)
        binding.rvStories.adapter?.notifyDataSetChanged()
        binding.rvStories.isNestedScrollingEnabled = false

    }

    private fun showErrorMessage(message: String) {
        val builder = AlertDialog.Builder(
            requireContext(),
            R.style.Theme_AppCompat_Light_Dialog_Alert
        )
        builder.setMessage(message)
        builder.setPositiveButton(android.R.string.ok) { dialog, _ ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun setCharacter(results: ArrayList<CharacterDataViewModel.Character>?) {
        binding.tvCharacterName.text = results?.first()?.name
        val url = String.format(
            "%s.%s",
            results?.first()?.thumbnail?.path,
            results?.first()?.thumbnail?.extension
        )
        setImgFromUri(binding.ivCharacterPhoto, url)
    }
}