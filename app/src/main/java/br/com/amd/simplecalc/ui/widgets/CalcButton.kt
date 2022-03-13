package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcButton(
    key: String,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onKeyPressed: (String) -> Unit
) {
    Button(
        modifier = modifier.size(60.dp),
        shape = shape,
        colors = colors,
        elevation = null,
        onClick = { onKeyPressed(key) }
    ) {
        Text(
            text = key,
            style = MaterialTheme.typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalcButtonPreview() {
    SimpleCalculatorTheme {
        CalcButton(key = "\u221A") { }
    }
}