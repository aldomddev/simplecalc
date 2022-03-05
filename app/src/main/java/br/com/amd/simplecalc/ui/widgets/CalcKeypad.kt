package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.amd.simplecalc.domain.model.KeyOperation
import br.com.amd.simplecalc.domain.model.KeyType
import br.com.amd.simplecalc.ui.model.KeyVO
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcKeyPad(
    onKeyPressed: (KeyVO) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalcButton(
                key = KeyVO(
                    label = "C",
                    keyType = KeyType.Operation(operation = KeyOperation.CLEAR)
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "\u221A",
                    keyType = KeyType.Operation(operation = KeyOperation.SQRT)
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "%",
                    keyType = KeyType.Operation(operation = KeyOperation.PERCENT)
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "/",
                    keyType = KeyType.Operation(operation = KeyOperation.DIVIDE)
                )
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalcButton(
                key = KeyVO(
                    label = "7",
                    keyType = KeyType.Value(value = "7")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "8",
                    keyType = KeyType.Value(value = "8")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "9",
                    keyType = KeyType.Value(value = "9")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "*",
                    keyType = KeyType.Operation(operation = KeyOperation.MULTIPLY)
                )
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalcButton(
                key = KeyVO(
                    label = "4",
                    keyType = KeyType.Value(value = "4")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "5",
                    keyType = KeyType.Value(value = "5")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "6",
                    keyType = KeyType.Value(value = "6")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "-",
                    keyType = KeyType.Operation(operation = KeyOperation.MINUS)
                )
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalcButton(
                key = KeyVO(
                    label = "1",
                    keyType = KeyType.Value(value = "1")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "2",
                    keyType = KeyType.Value(value = "2")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "3",
                    keyType = KeyType.Value(value = "3")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "+",
                    keyType = KeyType.Operation(operation = KeyOperation.PLUS)
                )
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalcButton(
                key = KeyVO(
                    label = "0",
                    keyType = KeyType.Value(value = "0")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = ".",
                    keyType = KeyType.Value(value = ".")
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "=",
                    keyType = KeyType.Operation(operation = KeyOperation.RESULT)
                ),
                modifier = Modifier.defaultMinSize(minWidth = ButtonDefaults.MinWidth * 2)
            ) { key -> onKeyPressed(key) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalcKeyPadPreview() {
    SimpleCalculatorTheme {
        CalcKeyPad { }
    }
}