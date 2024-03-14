package br.com.fiap.moneyconvert.data.api

import br.com.fiap.moneyconvert.data.model.ExchangeRateResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GetConvertion {
    @GET("{baseCoin}/{coinToConverter}/{valueToConverter}")
    suspend fun getConvertion(
        @Path("baseCoin") baseCoin: String,
        @Path("coinToConverter") coinToConverter: String,
        @Path("valueToConverter") valueToConverter: String,


        ): ExchangeRateResponse
}