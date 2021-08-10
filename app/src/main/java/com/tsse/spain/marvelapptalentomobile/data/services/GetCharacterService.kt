package com.tsse.spain.marvelapptalentomobile.data.services


import com.tsse.spain.marvelapptalentomobile.BuildConfig
import com.tsse.spain.marvelapptalentomobile.data.models.CharacterDataModelResponse
import com.tsse.spain.marvelapptalentomobile.utils.md5
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
Created By Diego Garzón on 09/08/2021
 */

interface GetCharacterService {
    @GET("/v1/public/characters/{characterId}")
    fun getCharacter(
        @Path(value = "characterId") characterId: String?,
        @Query("ts") ts: String? = "10000",
        @Query("apikey") apiKey: String? = BuildConfig.MARVEL_PUBLIC_KEY,
        @Query("hash") hash: String? = (ts + BuildConfig.MARVEL_PRIVATE_KEY + apiKey).md5()
    ): Call<CharacterDataModelResponse>

}


