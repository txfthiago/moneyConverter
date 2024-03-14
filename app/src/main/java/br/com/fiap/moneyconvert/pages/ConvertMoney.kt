package br.com.fiap.moneyconvert.pages;

import HeaderFragment
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.moneyconvert.R
import br.com.fiap.moneyconvert.pages.components.ExchangeRateButton
import br.com.fiap.moneyconvert.pages.components.MoneyTextField
import br.com.fiap.moneyconvert.pages.components.NumeroComDropdown
import br.com.fiap.moneyconvert.domain.model.ExchangeRate
import br.com.fiap.moneyconvert.services.ExchangeRateService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ConvertMoney(navController: NavController) {
    var exchangeRateResponse by remember { mutableStateOf<ExchangeRate?>(null) }
    val exchangeRateService = ExchangeRateService()

    var moneyValue by remember { mutableStateOf("") }

    var siglaDaMoedaQueVaiSerConvetida by remember {
        mutableStateOf("")
    }

    var siglaDaMoedaDestino by remember {
        mutableStateOf("")
    }

    val moedaQueVaiSerConvetida: (String) -> Unit = { newValue ->
        println("testt")
        siglaDaMoedaQueVaiSerConvetida = newValue
    }

    val moedaDestino: (String) -> Unit = { newValue ->
        siglaDaMoedaDestino = newValue
    }

    Row {
        HeaderFragment()
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),

        ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo EasyCambio",
            modifier = Modifier
                .width(200.dp)
                .padding(start = 20.dp, top = 20.dp),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp)
                .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(20.dp))
                .padding(start = 25.dp, end = 25.dp),
            contentAlignment = Alignment.Center

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                NumeroComDropdown("Selecione a Moeda que deseja converter", moedaQueVaiSerConvetida)
                Spacer(modifier = Modifier.height(20.dp))
                NumeroComDropdown("Selecione a moeda destino", moedaDestino)
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Insira o valor que deseja converter",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))

                MoneyTextField(
                    value = moneyValue,
                    onValueChange = { newValue ->
                        moneyValue = newValue
                    }
                )
            }


        }



        ExchangeRateButton(
            onClick = {
                CoroutineScope(Dispatchers.Main).launch {
                    exchangeRateService.getExchangeRate(
                        siglaDaMoedaQueVaiSerConvetida,
                        siglaDaMoedaDestino,
                        moneyValue,
                        onSuccess = { response ->
                            exchangeRateResponse = response
                        },
                        onError = { error ->
                            error.stackTrace
                        })
                }
            }
        )


        exchangeRateResponse?.let { response ->
            Text("Conversion rate: ${response.conversion_rate}")
            Text("Conversion result: ${response.conversion_result}")
        }


    }

}




