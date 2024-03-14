package br.com.fiap.moneyconvert.pages.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.moneyconvert.utils.Moedas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumeroComDropdown(
    texto: String,
    onValueChange: (String) -> Unit
) {
    var dropdownExpanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(texto) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 0.5.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(8.dp),

                    )
                .background(Color.White)

        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp))
            ) {

                TextButton(
                    onClick = { dropdownExpanded = !dropdownExpanded },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(selectedOption)
                }
                DropdownMenu(
                    expanded = dropdownExpanded,
                    onDismissRequest = { dropdownExpanded = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                ) {
                    Moedas.moedasMap.forEach { (sigla, descricao) ->
                        DropdownMenuItem(
                            onClick = {
                                selectedOption = sigla
                                dropdownExpanded = false
                                onValueChange(sigla)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            text = { Text("$sigla - $descricao") }

                        )
                    }
                }
            }
        }
    }
}

