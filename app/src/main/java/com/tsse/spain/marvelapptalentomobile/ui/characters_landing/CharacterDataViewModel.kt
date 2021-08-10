package com.tsse.spain.marvelapptalentomobile.ui.characters_landing

import java.util.Date
import java.util.ArrayList

/**
Created By Diego Garzón on 09/08/2021
 */

data class CharacterDataViewModel(
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
        val thumbnail: Image?, // The representative image for this character.
        val comics: ComicList?, // A resource list containing comics which feature this character.
        val stories: StoryList?, // A resource list of stories in which this character appears.
        val events: EventList?, // A resource list of events in which this character appears.
        val series: SeriesList? // A resource list of series in which this character appears.
    )

    data class Url(
        val type: String?,
        val url: String?
    )

    data class Image(
        val path: String?,
        val extension: String?
    )

    data class ComicList(
        val available: Int?,
        val returned: Int?,
        val collectionUri: String?,
        val items: ArrayList<ComicSummary>?
    )

    data class ComicSummary(
        val resourceURI: String?,
        val name: String?
    )

    data class StoryList(
        val available: Int?,
        val returned: Int?,
        val collectionUri: String?,
        val items: ArrayList<StorySummary>?
    )

    data class StorySummary(
        val resourceURI: String?,
        val name: String?,
        val type: String?
    )

    data class EventList(
        val available: Int?,
        val returned: Int?,
        val collectionUri: String?,
        val items: ArrayList<EventSummary>?
    )

    data class EventSummary(
        val resourceURI: String?,
        val name: String?
    )

    data class SeriesList(
        val available: Int?,
        val returned: Int?,
        val collectionUri: String?,
        val items: ArrayList<SeriesSummary>?
    )

    data class SeriesSummary(val resourceURI: String?, val name: String?)
}