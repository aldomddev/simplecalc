package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcDisplay(
    value: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Text(value)
    }
}

@Preview(showBackground = true)
@Composable
fun CalcDisplayPreview() {
    SimpleCalculatorTheme {
        CalcDisplay(value = "1 + 2")
    }
}