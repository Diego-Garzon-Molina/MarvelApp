package com.tsse.spain.marvelapptalentomobile.data

/**
Created By Diego Garzón on 10/08/2021
 */
abstract class DataMapper<X,D> {
  abstract fun dataToDomain(entryData: X?) : D?
  abstract fun domainToData(entryData: D?) : X?

  fun listDomainToData(entryData: ArrayList<D>?) : ArrayList<X> {
    val returnList = arrayListOf<X>()
    entryData?.forEach { domainToData(it)?.let { it1 -> returnList.add(it1) } }
    return returnList
  }

  fun listDataToDomain(entryData: ArrayList<X>?) : ArrayList<D>{
    val returnList = arrayListOf<D>()
    entryData?.forEach { dataToDomain(it)?.let { it1 -> returnList.add(it1) } }
    return returnList
  }
}