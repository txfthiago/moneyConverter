package br.com.fiap.moneyconvert.domain.repository

import br.com.fiap.moneyconvert.data.model.ExchangeRateResponse

interface ConvertionRepository {

    suspend fun getConvertion(
        baseCoin: String, coinToConverter: String, valueToConverter: String
    ): ExchangeRateResponse
}