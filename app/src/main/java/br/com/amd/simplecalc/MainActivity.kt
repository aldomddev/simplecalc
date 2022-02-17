package br.com.amd.simplecalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme
import br.com.amd.simplecalc.ui.widgets.CalcDisplay
import br.com.amd.simplecalc.ui.widgets.CalcKeyPad

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

@Composable
fun Calculator() {
    Column {
        CalcDisplay(value = "1 + 2")
        CalcKeyPad(onClick = { })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleCalculatorTheme {
        Calculator()
    }
}