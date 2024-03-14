package br.com.fiap.moneyconvert.pages

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.moneyconvert.R

@Composable
fun HomePage(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.BottomCenter
        )
    }

    Row {
        Image(
            painter = painterResource(id = R.drawable.menu_hamburguer_1_),
            contentDescription = "Descrição da imagem",
            modifier = Modifier.padding(vertical = 30.dp, horizontal = 20.dp)
        )

        Text(
            text = "Easycambio.com",
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                textDecoration = TextDecoration.Underline
            ),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 30.dp, horizontal = 10.dp)
        )
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Insira seu email para começar a realizar conversões.",
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

                ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 100.dp, horizontal = 50.dp)

        )

        var emailText by remember { mutableStateOf(TextFieldValue()) }

        Surface(
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 3.dp, horizontal = 60.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(40.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(40.dp))
        ) {
            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                modifier = Modifier.fillMaxSize(),
                placeholder = {
                    Text(text = "Digite seu email")
                }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = fun() { navController.navigate("ConvertMoney") }) {
            Text(text = "Começar a converter")

        }
    }

}

