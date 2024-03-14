package br.com.fiap.moneyconvert.data.mapper

import br.com.fiap.moneyconvert.data.model.ExchangeRateResponse
import br.com.fiap.moneyconvert.domain.model.ExchangeRate

fun ExchangeRateResponse.toDomain(): ExchangeRate {
    return ExchangeRate(
        base_code = base_code,
        target_code = target_code,
        conversion_rate = conversion_rate,
        conversion_result = conversion_result
    )


}
