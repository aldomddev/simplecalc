package br.com.amd.simplecalc.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.amd.simplecalc.domain.model.KeyOperation
import br.com.amd.simplecalc.domain.model.KeyType
import br.com.amd.simplecalc.ui.model.KeyVO
import br.com.amd.simplecalc.ui.theme.SimpleCalculatorTheme

@Composable
fun CalcKeyPad(
    darkTheme: Boolean,
    onKeyPressed: (KeyVO) -> Unit
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
                key = KeyVO(
                    label = "C",
                    keyType = KeyType.Operation(operation = KeyOperation.CLEAR)
                ),
                darkTheme = darkTheme
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "\u221A",
                    keyType = KeyType.Operation(operation = KeyOperation.SQRT)
                )
            ) { key -> onKeyPressed(key) }
            CalcButton(
                key = KeyVO(
                    label = "\u0025",
                    keyType = KeyType.Operation(operation = KeyOperation.PERCENT)
                )
            ) { key -> onKeyPressed(key) }
            SpecialCalcButton(
                key = KeyVO(
                    label = "\u00F7",
                    keyType = KeyType.Operation(operation = KeyOperation.DIVIDE)
                ),
                darkTheme = darkTheme
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
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
            SpecialCalcButton(
                key = KeyVO(
                    label = "\u00D7",
                    keyType = KeyType.Operation(operation = KeyOperation.MULTIPLY)
                ),
                darkTheme = darkTheme
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
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
            SpecialCalcButton(
                key = KeyVO(
                    label = "\u2212",
                    keyType = KeyType.Operation(operation = KeyOperation.MINUS)
                ),
                darkTheme = darkTheme
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
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
            SpecialCalcButton(
                key = KeyVO(
                    label = "\u002B",
                    keyType = KeyType.Operation(operation = KeyOperation.PLUS)
                ),
                darkTheme = darkTheme
            ) { key -> onKeyPressed(key) }
        }
        Row(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
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
            SpecialCalcButton(
                key = KeyVO(
                    label = "\u003D",
                    keyType = KeyType.Operation(operation = KeyOperation.RESULT)
                ),
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