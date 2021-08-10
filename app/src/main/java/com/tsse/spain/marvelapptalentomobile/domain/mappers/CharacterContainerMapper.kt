package com.tsse.spain.marvelapptalentomobile.domain.mappers

import com.tsse.spain.marvelapptalentomobile.domain.model.CharacterDomainModel
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharacterDataViewModel

/**
Created By Diego Garzón on 10/08/2021
 */
class CharacterContainerMapper : Mapper<CharacterDataViewModel, CharacterDomainModel>() {
    override fun domainToViewModel(entryData: CharacterDomainModel): CharacterDataViewModel {
        return CharacterDataViewModel(
            entryData.offset,
            entryData.limit,
            entryData.total,
            entryData.count,
            CharacterMapper().listDomainToViewModel(entryData.results)
        )
    }

    override fun viewModelToDomain(entryData: CharacterDataViewModel): CharacterDomainModel {
        return CharacterDomainModel(
            entryData.offset,
            entryData.limit,
            entryData.total,
            entryData.count,
            CharacterMapper().listViewModelToDomain(entryData.results)
        )
    }

}