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
import br.com.fiap.moneyconvert.pages.components.MoneyTextField
import br.com.fiap.moneyconvert.pages.components.NumeroComDropdown


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ConvertMoney(navController: NavController) {

    var moneyValue by remember { mutableStateOf("") }

    var baseCoin by remember {
        mutableStateOf("")
    }

    var converterCoin by remember {
        mutableStateOf("")
    }

    val moedaQueVaiSerConvetida: (String) -> Unit = { newValue ->
        println("testt")
        baseCoin = newValue
    }

    val moedaDestino: (String) -> Unit = { newValue ->
        converterCoin = newValue
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
                .height(450.dp)
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

//        Button(onClick = { CHAMAR API PASSANDO(moneyValue,
//                baseCoin,
//                converterCoin) }) {
//
//        }

//        EXIBIR RESPOSTAS


    }

}




