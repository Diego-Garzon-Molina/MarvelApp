package com.tsse.spain.marvelapptalentomobile.utils

import java.text.SimpleDateFormat
import java.util.*

/**
Created By Diego Garzón on 10/08/2021
 */
object DateUtil {
    //01/01/2017
    val DAY_MONTH_YEAR_FORMAT = "dd/MM/yyyy"
    val local = Locale("es")

   fun Date.toDDMMYYYYString(): String{
       val simpleDateFormat = SimpleDateFormat(DAY_MONTH_YEAR_FORMAT, local)
       return simpleDateFormat.format(Date())
   }
}