package br.com.amd.simplecalc.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme
import br.com.amd.simplecalc.ui.widgets.CalcDisplay
import br.com.amd.simplecalc.ui.widgets.CalcKeyPad
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val darkTheme by mainViewModel.darkTheme
            val displayValue by mainViewModel.displayValue
            val systemUiController = rememberSystemUiController()

            SimpleCalculatorTheme(darkTheme = darkTheme) {
                systemUiController.setSystemBarsColor(MaterialTheme.colors.primary)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Calculator(
                        darkTheme,
                        displayValue) { key->
                        mainViewModel.onKeyPressed(key = key)
                    }
                }
            }
        }
    }
}

@Composable
fun Calculator(
    darkTheme: Boolean,
    displayValue: String,
    onKeyPressed: (String) -> Unit
) {

    Column {
        CalcDisplay(value = displayValue)
        CalcKeyPad(
            darkTheme = darkTheme,
            onKeyPressed = { key -> onKeyPressed(key) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleCalculatorTheme {
        Calculator(darkTheme = true, displayValue = "123") { }
    }
}