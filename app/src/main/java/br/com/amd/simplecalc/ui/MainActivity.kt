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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.amd.simplecalc.domain.CalcProcessorImpl
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme
import br.com.amd.simplecalc.ui.widgets.CalcDisplay
import br.com.amd.simplecalc.ui.widgets.CalcKeyPad
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Calculator(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun Calculator(mainViewModel: MainViewModel) {
    val displayValue = mainViewModel.displayValue.value

    Column {
        CalcDisplay(value = displayValue)
        CalcKeyPad(onKeyPressed = { keyVO -> mainViewModel.onKeyPressed(keyVO = keyVO) })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleCalculatorTheme {
        Calculator(MainViewModel(CalcProcessorImpl()))
    }
}