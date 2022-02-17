package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.amd.simplecalc.ui.model.KeyOperation
import br.com.amd.simplecalc.ui.model.KeyType
import br.com.amd.simplecalc.ui.model.KeyVO
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcKeyPad(
    onClick: (KeyVO) -> Unit
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
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "+/-",
                    keyType = KeyType.Operation(operation = KeyOperation.INVERT_SIGNAL)
                )
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "%",
                    keyType = KeyType.Operation(operation = KeyOperation.PERCENT)
                )
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "/",
                    keyType = KeyType.Operation(operation = KeyOperation.DIVIDE)
                )
            ) { key -> onClick(key) }
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
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "8",
                    keyType = KeyType.Value(value = "8")
                )
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "9",
                    keyType = KeyType.Value(value = "9")
                )
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "x",
                    keyType = KeyType.Operation(operation = KeyOperation.MULTIPLY)
                )
            ) { key -> onClick(key) }
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
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "5",
                    keyType = KeyType.Value(value = "5")
                )
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "6",
                    keyType = KeyType.Value(value = "6")
                )
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "-",
                    keyType = KeyType.Operation(operation = KeyOperation.MINUS)
                )
            ) { key -> onClick(key) }
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
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "2",
                    keyType = KeyType.Value(value = "2")
                )
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "3",
                    keyType = KeyType.Value(value = "3")
                )
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "+",
                    keyType = KeyType.Operation(operation = KeyOperation.PLUS)
                )
            ) { key -> onClick(key) }
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
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = ".",
                    keyType = KeyType.Value(value = ".")
                )
            ) { key -> onClick(key) }
            CalcButton(
                key = KeyVO(
                    label = "=",
                    keyType = KeyType.Operation(operation = KeyOperation.RESULT)
                ),
                modifier = Modifier.defaultMinSize(minWidth = ButtonDefaults.MinWidth * 2)
            ) { key -> onClick(key) }
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