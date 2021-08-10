package com.tsse.spain.marvelapptalentomobile.data

import com.tsse.spain.marvelapptalentomobile.data.models.CharacterDataModelResponse
import com.tsse.spain.marvelapptalentomobile.domain.model.CharacterDomainModel

/**
Created By Diego Garzón on 10/08/2021
 */
class CharacterResponseMapper: DataMapper<CharacterDataModelResponse, CharacterDomainModel>() {
    override fun dataToDomain(entryData: CharacterDataModelResponse?): CharacterDomainModel? {
        return entryData?.data
    }

    override fun domainToData(entryData: CharacterDomainModel?): CharacterDataModelResponse? {
        return null
    }
}