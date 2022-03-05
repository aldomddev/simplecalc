package br.com.amd.simplecalc.domain

import androidx.core.text.isDigitsOnly
import java.text.DecimalFormat
import javax.inject.Inject
import kotlin.math.sqrt

class CalcProcessorImpl @Inject constructor() : CalcProcessor {

    private val operationsRegex = """[$PLUS\$MINUS$MULTIPLY$DIVIDE]""".toRegex()
    private val inputAccumulator = StringBuilder("0")

    private var operation: String = ""

    override fun processKey(key: String): String {
        return when {
            key.containsOperationChar() -> appendArithmeticOperation(operation = key)
            key.isDigitsOnly() -> appendDigit(digit = key)
            key == PERCENTAGE -> appendPercentage()
            key == DECIMAL_SEPARATOR -> appendDecimalSeparator()
            key == CLEAR -> clear()
            key == SQUARED_ROOT -> calcSquaredRoot()
            key == RESULT -> calcResult()
            else -> inputAccumulator.toString()
        }
    }

    private fun appendArithmeticOperation(operation: String): String {
        this.operation = operation

        if (inputAccumulator.containsOperationChar()) {
            inputAccumulator.replace(inputAccumulator.length - 2, inputAccumulator.length - 1, operation)
        } else {
            inputAccumulator.append(" $operation ")
        }

        return inputAccumulator.toString()
    }

    private fun appendDigit(digit: String): String {
        if (inputAccumulator.toString() == "0") {
            inputAccumulator[0] = digit[0]
        } else {
            inputAccumulator.append(digit)
        }
        return inputAccumulator.toString()
    }

    private fun appendDecimalSeparator(): String {
        if (!inputAccumulator.contains(DECIMAL_SEPARATOR)) {
            inputAccumulator.append(DECIMAL_SEPARATOR)
        }

        return inputAccumulator.toString()
    }

    private fun appendPercentage(): String {
        if (inputAccumulator.last().isDigit() && inputAccumulator.last() != PERCENTAGE[0]) {
            inputAccumulator.append(PERCENTAGE)
        }

        return inputAccumulator.toString()
    }

    private fun calcSquaredRoot(): String {
        val result = calcResult()
        return if (operation.isNotEmpty() && result.contains(operation)) {
            result
        } else {
            sqrt(result.toDouble()).toString()
        }
    }

    private fun calcResult(): String {
        if (inputAccumulator.last().isDigit() || inputAccumulator.last() == PERCENTAGE[0]) {
            val values = inputAccumulator.split(" $operation ")

            val result = if (operation.isNotEmpty()) {
                val value1IsPercent = values[0].contains(PERCENTAGE)
                val value2IsPercent = values[1].contains(PERCENTAGE)

                val value1 = if (value1IsPercent) {
                    values[0].replace(PERCENTAGE, "").toDouble().percentage()
                } else {
                    values[0].toDouble()
                }

                val value2 = if (value2IsPercent) {
                    values[1].replace(PERCENTAGE, "").toDouble().percentage()
                } else {
                    values[1].toDouble()
                }

                when (operation) {
                    PLUS -> if (value2IsPercent) (value1 + value1 * value2) else (value1 + value2)
                    MINUS -> if (value2IsPercent) (value1 - value1 * value2) else (value1 - value2)
                    MULTIPLY -> value1 * value2
                    DIVIDE -> value1 / value2
                    else -> 0.0
                }
            } else {
                values[0].replace(PERCENTAGE, "").toDouble().percentage()
            }

            clear()
            inputAccumulator.replace(0, inputAccumulator.length, result.asFormattedString())
        }

        return inputAccumulator.toString()
    }

    private fun clear(): String {
        operation = ""
        inputAccumulator.clear().append("0")
        return inputAccumulator.toString()
    }

    // region extensions
    private fun String.containsOperationChar() = this.contains(operationsRegex)

    private fun StringBuilder.containsOperationChar() = this.contains(operationsRegex)

    private fun Double.percentage() = this.div(100.0)

    private fun Double.asFormattedString(): String {
        return DecimalFormat("0.#####").format(this).replace(",", ".")
    }
    // endregion

    private companion object {
        const val DECIMAL_SEPARATOR = "."
        const val PLUS = "+"
        const val MINUS = "-"
        const val MULTIPLY = "*"
        const val DIVIDE = "/"
        const val PERCENTAGE = "%"
        const val RESULT = "="
        const val CLEAR = "C"
        const val SQUARED_ROOT = "\u221A"
    }
}