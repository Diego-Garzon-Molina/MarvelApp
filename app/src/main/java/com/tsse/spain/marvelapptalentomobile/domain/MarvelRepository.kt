package com.tsse.spain.marvelapptalentomobile.domain

import com.tsse.spain.marvelapptalentomobile.domain.model.CharacterDomainModel

/**
Created By Diego Garzón on 10/08/2021
 */
interface MarvelRepository {
    fun getCharacterList(): Either<Exception, CharacterDomainModel?>
    fun getCharacter(characterId: String): Either<Exception, CharacterDomainModel?>
}