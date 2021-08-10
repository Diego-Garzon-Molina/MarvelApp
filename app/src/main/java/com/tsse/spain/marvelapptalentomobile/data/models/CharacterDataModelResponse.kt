package com.tsse.spain.marvelapptalentomobile.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.tsse.spain.marvelapptalentomobile.domain.model.CharacterDomainModel


/**
Created By Diego Garzón on 09/08/2021
 */


open class CharacterDataModelResponse() : Parcelable {
    @SerializedName("code")
    @Expose
    val code: Int? = null

    @SerializedName("status")
    @Expose
    val status: String? = null

    @SerializedName("copyright")
    @Expose
    val copyright: String? = null

    @SerializedName("attributionText")
    @Expose
    val attributionText: String? = null

    @SerializedName("attributionHTML")
    @Expose
    val attributionHTML: String? = null

    @SerializedName("data")
    @Expose
    val data: CharacterDomainModel? = null

    @SerializedName("etag")
    @Expose
    val etag: String? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        // Do Nothing
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterDataModelResponse> {
        override fun createFromParcel(parcel: Parcel): CharacterDataModelResponse {
            return CharacterDataModelResponse(parcel)
        }

        override fun newArray(size: Int): Array<CharacterDataModelResponse?> {
            return arrayOfNulls(size)
        }
    }
}
