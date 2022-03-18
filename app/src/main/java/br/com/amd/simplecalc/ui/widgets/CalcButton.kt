package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.amd.simplecalc.ui.theme.Amber500
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcButton(
    key: String,
    modifier: Modifier = Modifier,
    width: Dp = 60.dp,
    height: Dp = width,
    shape: Shape = CircleShape,
    backgroundColor: Color = MaterialTheme.colors.primary,
    contentColor: Color = contentColorFor(backgroundColor),
    onKeyPressed: (String) -> Unit
) {
    Button(
        modifier = modifier.requiredSize(width, height),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
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