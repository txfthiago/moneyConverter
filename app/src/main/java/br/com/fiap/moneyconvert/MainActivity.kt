package br.com.fiap.moneyconvert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.moneyconvert.pages.ConvertMoney
import br.com.fiap.moneyconvert.pages.HomePage
import br.com.fiap.moneyconvert.ui.theme.MoneyConvertTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyConvertTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "HomePage") {
                    composable(
                        route = "HomePage"
                    ) {
                        HomePage(navController)
                    }
                    composable(
                        route = "ConvertMoney"
                    ) {
                        ConvertMoney(navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()

    MoneyConvertTheme {
        HomePage(navController)
    }
}