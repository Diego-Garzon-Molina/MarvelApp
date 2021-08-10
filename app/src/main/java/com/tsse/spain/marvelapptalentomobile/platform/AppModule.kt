package com.tsse.spain.marvelapptalentomobile.platform

import com.tsse.spain.marvelapptalentomobile.data.repositories.CharacterRepository
import com.tsse.spain.marvelapptalentomobile.domain.MarvelRepository
import com.tsse.spain.marvelapptalentomobile.domain.use_cases.GetCharacterUseCase
import com.tsse.spain.marvelapptalentomobile.domain.use_cases.GetCharactersListUseCase
import com.tsse.spain.marvelapptalentomobile.ui.character.CharacterViewModel
import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharactersLandingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
Created By Diego Garzón on 10/08/2021
 */

val appModule = module {
    single<MarvelRepository> {
        CharacterRepository()
    }
    single<InteractorExecutor> {
        AsyncInteractorExecutor(
            runOnBgThread = BackgroundRunner(),
            runOnMainThread = MainRunner()
        )
    }
    factory { GetCharactersListUseCase(repository = get()) }
    factory { GetCharacterUseCase(repository = get()) }

    viewModel {
        CharactersLandingViewModel(
            executor = get(),
            useCaseCharacters = get()
        )
    }

    viewModel {
        CharacterViewModel(
            executor = get(),
            useCaseCharacters = get()
        )
    }
}
