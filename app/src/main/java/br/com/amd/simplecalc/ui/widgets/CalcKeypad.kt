package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcKeyPad(
    darkTheme: Boolean,
    onKeyPressed: (String) -> Unit
) {
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
            SpecialCalcButton(
                key = "C",
                darkTheme = darkTheme
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "\u221A"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "\u0025"
            ) { key -> onKeyPressed(key) }
            SpecialCalcButton(
                key = "\u00F7",
                darkTheme = darkTheme
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
            SpecialCalcButton(
                key = "\u00D7",
                darkTheme = darkTheme
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
            SpecialCalcButton(
                key = "\u2212",
                darkTheme = darkTheme
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
            SpecialCalcButton(
                key = "\u002B",
                darkTheme = darkTheme
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CalcButton(
                key = "0"
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = "."
            ) { key -> onKeyPressed(key) }
            SpecialCalcButton(
                key = "\u003D",
                darkTheme = darkTheme,
                modifier = Modifier.width(160.dp).height(80.dp)
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