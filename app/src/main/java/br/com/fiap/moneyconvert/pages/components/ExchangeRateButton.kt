package br.com.fiap.moneyconvert.pages.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ExchangeRateButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ) {
        Text(text = "Converter")
    }
}