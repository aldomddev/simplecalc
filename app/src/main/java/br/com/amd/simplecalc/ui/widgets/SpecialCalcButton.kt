package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import br.com.amd.simplecalc.domain.model.KeyType
import br.com.amd.simplecalc.ui.model.KeyVO
import br.com.amd.simplecalc.ui.theme.Amber100
import br.com.amd.simplecalc.ui.theme.Amber500
import br.com.amd.simplecalc.ui.theme.BlueGray50
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun SpecialCalcButton(
    key: KeyVO,
    darkTheme: Boolean,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    onClick: (KeyVO) -> Unit
) {
    val background = if (darkTheme) Amber100 else BlueGray50
    CalcButton(
        key = key,
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = background,
            contentColor = Amber500
        ),
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
fun SpecialCalcButtonPreview() {
    SimpleCalculatorTheme {
        CalcButton(key = KeyVO(label = "\u221A", keyType = KeyType.Value(""))) { }
    }
}