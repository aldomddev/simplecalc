package br.com.amd.simplecalc.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme
import br.com.amd.simplecalc.ui.widgets.CalcDisplay
import br.com.amd.simplecalc.ui.widgets.CalcKeyPad
import br.com.amd.simplecalc.ui.widgets.ThemeSwitch
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
                        darkTheme = darkTheme,
                        onThemeChanged = { darkTheme -> mainViewModel.onChangeTheme(darkTheme = darkTheme) },
                        displayValue = displayValue
                    ) { key->
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
    onThemeChanged: (darkTheme: Boolean) -> Unit,
    onKeyPressed: (key: String) -> Unit
) {
    Column(modifier = Modifier.background(MaterialTheme.colors.primary)) {
        Box(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
            ThemeSwitch(
                width = 60.dp,
                checked = darkTheme,
                onCheckedChange = { value -> onThemeChanged(value) }
            )
        }
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
        Calculator(darkTheme = true, displayValue = "123", onThemeChanged =  {}) { }
    }
}