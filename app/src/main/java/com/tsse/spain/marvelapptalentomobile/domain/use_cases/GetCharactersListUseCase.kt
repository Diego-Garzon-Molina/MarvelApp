package com.tsse.spain.marvelapptalentomobile.domain.use_cases

import com.tsse.spain.marvelapptalentomobile.domain.Either
import com.tsse.spain.marvelapptalentomobile.domain.Interactor
import com.tsse.spain.marvelapptalentomobile.domain.MarvelRepository
import com.tsse.spain.marvelapptalentomobile.domain.mappers.CharacterContainerMapper
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharacterDataViewModel

/**
Created By Diego Garzón on 10/08/2021
 */
class GetCharactersListUseCase(private val repository: MarvelRepository) :
    Interactor<String, CharacterDataViewModel> {

    override fun invoke(request: String): Either<Exception, CharacterDataViewModel> {
        val response = repository.getCharacterList()
        return if (response.isLeft) {
            Either.left(response.leftValue)
        } else {
            Either.right(CharacterContainerMapper().domainToViewModel(response.rightValue!!))
        }
    }

}