package br.com.amd.simplecalc.ui.widgets

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.amd.simplecalc.domain.model.KeyType
import br.com.amd.simplecalc.ui.model.KeyVO
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcButton(
    key: KeyVO,
    modifier: Modifier = Modifier,
    onClick: (KeyVO) -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { onClick(key) }
    ) {
        Text(text = key.label)
    }
}

@Preview(showBackground = true)
@Composable
fun CalcButtonPreview() {
    SimpleCalculatorTheme {
        CalcButton(key = KeyVO(label = "\u221A", keyType = KeyType.Value(""))) { }
    }
}