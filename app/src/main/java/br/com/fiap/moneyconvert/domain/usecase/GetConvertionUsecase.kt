package br.com.fiap.moneyconvert.domain.usecase

import br.com.fiap.moneyconvert.data.mapper.toDomain
import br.com.fiap.moneyconvert.domain.model.ExchangeRate
import br.com.fiap.moneyconvert.domain.repository.ConvertionRepository
import javax.inject.Inject

class GetConvertionUsecase @Inject constructor(
    private val repository: ConvertionRepository
) {

    suspend operator fun invoke(
        baseCoin: String,
        coinToConverter: String,
        valueToConverter: String
    ): ExchangeRate {
        return repository.getConvertion(baseCoin, coinToConverter, valueToConverter).toDomain()
    }
}