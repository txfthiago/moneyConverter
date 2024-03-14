package br.com.fiap.moneyconvert.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExchangeRate(
    val base_code: String,
    val target_code: String,
    val conversion_rate: Double,
    val conversion_result: Double
): Parcelable

