package com.tsse.spain.marvelapptalentomobile.domain.mappers

import com.tsse.spain.marvelapptalentomobile.domain.model.CharacterDomainModel
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharacterDataViewModel

/**
Created By Diego Garzón on 10/08/2021
 */
class CharacterMapper : Mapper<CharacterDataViewModel.Character, CharacterDomainModel.Character>() {
    override fun domainToViewModel(entryData: CharacterDomainModel.Character): CharacterDataViewModel.Character {
        return CharacterDataViewModel.Character(
            entryData.id,
            entryData.name,
            if (!entryData.description.isNullOrBlank()) entryData.description else null,
            entryData.modified,
            entryData.resourceURI,
            UrlMapper().listDomainToViewModel(entryData.urls),
            entryData.thumbnail,
            entryData.comics,
            entryData.stories,
            entryData.events,
            entryData.series
        )
    }

    override fun viewModelToDomain(entryData: CharacterDataViewModel.Character): CharacterDomainModel.Character {
        return CharacterDomainModel.Character(
            entryData.id,
            entryData.name,
            entryData.description,
            entryData.modified,
            entryData.resourceURI,
            UrlMapper().listViewModelToDomain(entryData.urls),
            entryData.thumbnail,
            entryData.comics,
            entryData.stories,
            entryData.events,
            entryData.series
        )
    }

}