package br.com.fiap.moneyconvert.data.repository

import br.com.fiap.moneyconvert.data.api.GetConvertion
import br.com.fiap.moneyconvert.data.model.ExchangeRateResponse
import br.com.fiap.moneyconvert.domain.repository.ConvertionRepository
import javax.inject.Inject

class ConvertionRepositoryImpl @Inject constructor(
    private val serviceApi: GetConvertion
) : ConvertionRepository {
    override suspend fun getConvertion(
        baseCoin: String,
        coinToConverter: String,
        valueToConverter: String
    ): ExchangeRateResponse {
        return serviceApi.getConvertion(baseCoin, coinToConverter, valueToConverter)
    }
}