package com.tsse.spain.marvelapptalentomobile.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsse.spain.marvelapptalentomobile.domain.use_cases.GetCharacterUseCase
import com.tsse.spain.marvelapptalentomobile.platform.InteractorExecutor
import com.tsse.spain.marvelapptalentomobile.platform.Resource
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharacterDataViewModel

class CharacterViewModel(
    private val executor: InteractorExecutor,
    private val useCaseCharacters: GetCharacterUseCase
) : ViewModel() {
    var listCharacters = MutableLiveData<Resource<CharacterDataViewModel>>()

    fun load(characterId: String) {
        getCharacterInvoke(characterId)
    }

    private fun getCharacterInvoke(characterId: String){
        listCharacters.value = Resource.loading()
        executor(
            interactor = useCaseCharacters,
            request = characterId,
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
