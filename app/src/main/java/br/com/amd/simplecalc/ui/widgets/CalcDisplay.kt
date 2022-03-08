package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.amd.simplecalc.ui.theme.Amber500
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcDisplay(
    value: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .padding(top = 30.dp, bottom = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.Bold,
            color = Amber500
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalcDisplayPreview() {
    SimpleCalculatorTheme {
        CalcDisplay(value = "1 + 2")
    }
}