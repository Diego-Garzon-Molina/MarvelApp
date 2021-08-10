package com.tsse.spain.marvelapptalentomobile.platform

import com.tsse.spain.marvelapptalentomobile.platform.Status.SUCCESS
import com.tsse.spain.marvelapptalentomobile.platform.Status.ERROR
import com.tsse.spain.marvelapptalentomobile.platform.Status.LOADING

/**
Created By Diego Garzón on 09/08/2021
 */
data class Resource<out T>(
  val status: Status,
  val data: T?,
  val exception: Exception?
) {
  companion object {
    fun <T> success(data: T?): Resource<T> {
      return Resource(SUCCESS, data, null)
    }

    fun <T> error(exception: Exception): Resource<T> {
      return Resource(ERROR, null, exception)
    }

    fun <T> loading(): Resource<T> {
      return Resource(LOADING, null, null)
    }
  }
}
