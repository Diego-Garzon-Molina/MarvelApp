package com.tsse.spain.marvelapptalentomobile.ui.characters_landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsse.spain.marvelapptalentomobile.R
import com.tsse.spain.marvelapptalentomobile.databinding.CharactersLandingFragmentBinding
import com.tsse.spain.marvelapptalentomobile.platform.Resource
import com.tsse.spain.marvelapptalentomobile.platform.Status
import com.tsse.spain.marvelapptalentomobile.ui.character.CharacterFragment
import org.koin.android.viewmodel.ext.android.getViewModel

class CharactersLandingFragment : Fragment() {
    private var _binding: CharactersLandingFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharactersLandingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CharactersLandingFragmentBinding.inflate(inflater, container, false)
        binding.refreshLayout.setOnRefreshListener { setObservers() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel(CharactersLandingViewModel::class)
        setObservers()
    }

    private fun setObservers() {
        viewModel.listCharacters.observe(requireActivity(), { charactersData ->
            when (charactersData.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    hideLoading()
                    showErrorMessage(charactersData.exception?.message!!)
                }
                Status.SUCCESS -> {
                    hideLoading()
                    setCharactersRecycler(charactersData)
                    viewModel.listCharacters.removeObservers(requireActivity())
                }
            }
        })
        viewModel.load()
    }

    private fun hideLoading() {
        binding.refreshLayout.isRefreshing = false
        binding.progressBar.visibility = View.GONE
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

    private fun setCharactersRecycler(charactersList: Resource<CharacterDataViewModel>) {
        binding.message.text =
            String.format("Numero de personajes recuperados: %s", charactersList.data?.count)
        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCharacters.adapter =
            CharacterAdapter(charactersList.data?.results, ::navigateToCharacter)
        binding.rvCharacters.adapter?.notifyDataSetChanged()
    }

    private fun navigateToCharacter(characterId: String) {
        val action =
            CharactersLandingFragmentDirections.actionCharactersLandingFragmentToCharacterFragment(
                characterId
            )
        this.findNavController().navigate(action)
    }
}