package com.tsse.spain.marvelapptalentomobile.domain.mappers

/**
Created By Diego Garzón on 10/08/2021
 */
abstract class Mapper<V,D> {
  abstract fun domainToViewModel(entryData: D) : V
  abstract fun viewModelToDomain(entryData: V) : D

  fun listDomainToViewModel(entryData: ArrayList<D>?) : ArrayList<V> {
    val returnList = arrayListOf<V>()
    entryData?.forEach { returnList.add(domainToViewModel(it)) }
    return returnList
  }

  fun listViewModelToDomain(entryData: ArrayList<V>?) : ArrayList<D>{
    val returnList = arrayListOf<D>()
    entryData?.forEach { returnList.add(viewModelToDomain(it)) }
    return returnList
  }
}