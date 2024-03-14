package br.com.fiap.moneyconvert.pages.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException
import java.util.Currency
import java.util.Locale

@Composable
fun MoneyTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    val decimalFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault()) as DecimalFormat
    decimalFormatter.maximumFractionDigits = 2
    decimalFormatter.isGroupingUsed = false
    decimalFormatter.currency = Currency.getInstance("BRL")

    val formattedValue = remember(value) {
        val number = try {
            val parsed = decimalFormatter.parse(value)
            parsed?.toDouble() ?: 0.0
        } catch (e: ParseException) {
            0.0
        }
        decimalFormatter.format(number)
    }

    TextField(
        value = formattedValue,
        onValueChange = { newValue: String ->
            val cleanString = newValue.replace(Regex("\\D"), "")
            val doubleValue = cleanString.toDoubleOrNull() ?: 0.0
            val newValueFormatted = decimalFormatter.format(doubleValue / 100.0)
            onValueChange(newValueFormatted)
        },
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(0.dp, Color.Transparent),
                shape = MaterialTheme.shapes.medium
            )
            .padding(bottom = 1.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start)
    )

}
