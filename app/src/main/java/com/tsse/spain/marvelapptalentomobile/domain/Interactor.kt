package com.tsse.spain.marvelapptalentomobile.domain

/**
Created By Diego Garzón on 10/08/2021
 */
interface Interactor<Request, Response> {

    operator fun invoke(request: Request): Either<Exception, Response>
}