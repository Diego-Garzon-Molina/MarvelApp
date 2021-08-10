package com.tsse.spain.marvelapptalentomobile.domain.model

import com.tsse.spain.marvelapptalentomobile.ui.characters_landing.CharacterDataViewModel
import java.util.Date

/**
Created By Diego Garzón on 10/08/2021
 */

data class CharacterDomainModel(
    val offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    val results: ArrayList<Character>
) {

    data class Character(
        val id: Int?, // The unique ID of the character resource
        val name: String?, // The name of the character
        val description: String?, // A short bio or description of the character
        val modified: Date?, // The date the resource was most recently modified
        val resourceURI: String?, // The canonical URL identifier for this resource
        val urls: ArrayList<Url>?, // A set of public web site URLs for the resource
        val thumbnail: CharacterDataViewModel.Image?, // The representative image for this character.
        val comics: CharacterDataViewModel.ComicList?, // A resource list containing comics which feature this character.
        val stories: CharacterDataViewModel.StoryList?, // A resource list of stories in which this character appears.
        val events: CharacterDataViewModel.EventList?, // A resource list of events in which this character appears.
        val series: CharacterDataViewModel.SeriesList? // A resource list of series in which this character appears.
    )

    data class Url(
        val type: String?,
        val url: String?
    )

}