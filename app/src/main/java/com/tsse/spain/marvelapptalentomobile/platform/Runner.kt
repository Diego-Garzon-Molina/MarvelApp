package com.tsse.spain.marvelapptalentomobile.platform

interface Runner {
  operator fun invoke(c: () -> Unit)
}
