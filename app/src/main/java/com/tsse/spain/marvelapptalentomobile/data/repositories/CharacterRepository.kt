package com.tsse.spain.marvelapptalentomobile.data.repositories

import com.tsse.spain.marvelapptalentomobile.data.CharacterResponseMapper
import com.tsse.spain.marvelapptalentomobile.data.models.CharacterDataModelResponse
import com.tsse.spain.marvelapptalentomobile.data.services.GetCharacterService
import com.tsse.spain.marvelapptalentomobile.data.services.GetCharactersListService
import com.tsse.spain.marvelapptalentomobile.domain.Either
import com.tsse.spain.marvelapptalentomobile.domain.MarvelRepository
import com.tsse.spain.marvelapptalentomobile.domain.model.CharacterDomainModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


/**
Created By Diego Garzón on 09/08/2021
 */

class CharacterRepository : MarvelRepository {
    private val getCharactersListService: GetCharactersListService
    private val getCharacterService: GetCharacterService

    override fun getCharacterList(): Either<Exception, CharacterDomainModel?> {
        return try {
            val response = getCharactersListService.getCharacters().execute()
            if (response.isSuccessful) {
                Either.right(CharacterResponseMapper().dataToDomain(response.body()))
            } else {
                Either.left(Exception("An error has occurred with the server"))
            }
        } catch (exception: IOException) {
            Either.left(Exception("The connection has failed"))
        }
    }

    override fun getCharacter(characterId: String): Either<Exception, CharacterDomainModel?> {
        return try {
            val response = getCharacterService.getCharacter(characterId = characterId).execute()
            if (response.isSuccessful) {
                Either.right(CharacterResponseMapper().dataToDomain(response.body()))
            } else {
                Either.left(Exception("An error has occurred with the server"))
            }
        } catch (exception: IOException) {
            Either.left(Exception("The connection has failed"))
        }
    }


    companion object {
        private const val CHARACTER_SERVICE_BASE_URL = "https://gateway.marvel.com"
    }

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        getCharactersListService = Retrofit.Builder()
            .baseUrl(CHARACTER_SERVICE_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetCharactersListService::class.java)
        getCharacterService = Retrofit.Builder()
            .baseUrl(CHARACTER_SERVICE_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetCharacterService::class.java)
    }
}