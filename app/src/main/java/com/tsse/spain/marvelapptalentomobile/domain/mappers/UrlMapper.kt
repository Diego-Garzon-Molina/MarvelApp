package com.tsse.spain.marvelapptalentomobile.domain.mappers

import com.tsse.spain.marvelapptalentomobile.domain.model.CharacterDomainModel
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharacterDataViewModel

/**
Created By Diego Garzón on 10/08/2021
 */
class UrlMapper : Mapper<CharacterDataViewModel.Url, CharacterDomainModel.Url>() {
    override fun domainToViewModel(entryData: CharacterDomainModel.Url): CharacterDataViewModel.Url {
        return CharacterDataViewModel.Url(entryData.type, entryData.url)
    }

    override fun viewModelToDomain(entryData: CharacterDataViewModel.Url): CharacterDomainModel.Url {
        return CharacterDomainModel.Url(entryData.type, entryData.url)
    }

}