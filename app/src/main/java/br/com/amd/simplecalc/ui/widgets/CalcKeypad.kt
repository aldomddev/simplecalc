package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.amd.simplecalc.ui.theme.Amber100
import br.com.amd.simplecalc.ui.theme.Amber500
import br.com.amd.simplecalc.ui.theme.BlueGray50
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcKeyPad(
    darkTheme: Boolean,
    onKeyPressed: (String) -> Unit
) {
    val buttonBackgroundColor = if (darkTheme) Amber100 else BlueGray50
    val buttonContentColor = Amber500

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Row(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CalcButton(
                key = "C",
                backgroundColor = buttonBackgroundColor,
                contentColor = buttonContentColor
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "\u221A"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "\u0025"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "\u00F7",
                backgroundColor = buttonBackgroundColor,
                contentColor = buttonContentColor,
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CalcButton(
                key = "7"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "8"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "9"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "\u00D7",
                backgroundColor = buttonBackgroundColor,
                contentColor = buttonContentColor
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CalcButton(
                key = "4"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "5"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "6"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "\u2212",
                backgroundColor = buttonBackgroundColor,
                contentColor = buttonContentColor
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CalcButton(
                key = "1"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "2"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "3"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "\u002B",
                backgroundColor = buttonBackgroundColor,
                contentColor = buttonContentColor
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CalcButton(
                key = "0"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "."
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "\u003D",
                width = 160.dp,
                height = 60.dp,
                backgroundColor = buttonBackgroundColor,
                contentColor = buttonContentColor
            ) { key -> onKeyPressed(key) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalcKeyPadPreview() {
    SimpleCalculatorTheme {
        CalcKeyPad(darkTheme = true) { }
    }
}