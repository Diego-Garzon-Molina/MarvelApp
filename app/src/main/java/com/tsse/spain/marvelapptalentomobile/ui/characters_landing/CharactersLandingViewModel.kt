package com.tsse.spain.marvelapptalentomobile.ui.characters_landing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsse.spain.marvelapptalentomobile.domain.use_cases.GetCharactersListUseCase
import com.tsse.spain.marvelapptalentomobile.platform.InteractorExecutor
import com.tsse.spain.marvelapptalentomobile.platform.Resource

class CharactersLandingViewModel(
    private val executor: InteractorExecutor,
    private val useCaseCharacters: GetCharactersListUseCase
) : ViewModel() {
    var listCharacters = MutableLiveData<Resource<CharacterDataViewModel>>()

    fun load() {
        getCharacterInvoke()
    }

    fun refresh() {
        getCharacterInvoke()
    }

    private fun getCharacterInvoke(){
        listCharacters.value = Resource.loading()
        executor(
            interactor = useCaseCharacters,
            request = "",
            onError = {
                listCharacters.value = Resource.error(it)
            },
            onSuccess = {
                listCharacters.value =
                    Resource.success(it)
            }
        )
    }

}
