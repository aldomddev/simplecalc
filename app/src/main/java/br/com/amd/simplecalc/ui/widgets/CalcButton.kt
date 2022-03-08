package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.amd.simplecalc.domain.model.KeyType
import br.com.amd.simplecalc.ui.model.KeyVO
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme
import br.com.amd.simplecalc.ui.theme.Typography

@Composable
fun CalcButton(
    key: KeyVO,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: (KeyVO) -> Unit
) {
    Button(
        modifier = modifier.size(80.dp),
        shape = shape,
        colors = colors,
        elevation = null,
        onClick = { onClick(key) }
    ) {
        Text(
            text = key.label,
            style = MaterialTheme.typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalcButtonPreview() {
    SimpleCalculatorTheme {
        CalcButton(key = KeyVO(label = "\u221A", keyType = KeyType.Value(""))) { }
    }
}