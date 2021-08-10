package com.tsse.spain.marvelapptalentomobile.platform

import com.tsse.spain.marvelapptalentomobile.domain.Interactor

/**
Created By Diego Garzón on 10/08/2021
 */

interface InteractorExecutor {

    operator fun <Request, Response> invoke(
        interactor: Interactor<Request, Response>,
        request: Request,
        onError: (Exception) -> Unit = {},
        onSuccess: (Response) -> Unit = {}
    )
}