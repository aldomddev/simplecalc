package br.com.amd.simplecalc.domain

import androidx.core.text.isDigitsOnly
import java.text.DecimalFormat
import javax.inject.Inject
import kotlin.math.sqrt

class CalcProcessorImpl @Inject constructor() : CalcProcessor {

    private val operationsRegex = Regex.fromLiteral("\\s[\\+\\-\\*\\/]{1}\$")
    private var input = StringBuilder("0")

    private var value1: Double = 0.0
    private var value2: Double = 0.0
    private var operation: String = ""

    override fun processKey(key: String): String {
        return when {
            key == PLUS ||
                    key == MINUS ||
                    key == MULTIPLY ||
                    key == DIVIDE -> appendArithmeticOperation(operation = key)
            key.isDigitsOnly() -> appendDigit(digit = key)
            key == PERCENTAGE -> appendPercentage()
            key == DECIMAL_SEPARATOR -> appendDecimalSeparator()
            key == CLEAR -> clear()
            key == SQRT -> calcSquaredRoot()
            key == RESULT -> calcResult()
            else -> input.toString()
        }
    }

    private fun appendArithmeticOperation(operation: String): String {
        if (this.operation.isNotEmpty()) return input.toString()
        this.operation = operation

        if (input.contains(operationsRegex)) {
            input.insert(input.length - 1, operation)
        } else {
            input.append(" $operation ")
        }

        return input.toString()
    }

    private fun appendDigit(digit: String): String {
        if (input.toString() == "0") {
            input[0] = digit[0]
        } else {
            input.append(digit)
        }
        return input.toString()
    }

    private fun appendDecimalSeparator(): String {
        if (!input.contains(DECIMAL_SEPARATOR)) {
            input.append(DECIMAL_SEPARATOR)
        }

        return input.toString()
    }

    private fun appendPercentage(): String {
        if (input.last().isDigit() && input.last() != PERCENTAGE[0]) {
            input.append(PERCENTAGE)
        }

        return input.toString()
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
        if (input.last().isDigit() || input.last() == PERCENTAGE[0]) {
            val values = input.split(" $operation ")

            val result = if (operation.isNotEmpty()) {
                val value1IsPercent = values[0].contains(PERCENTAGE)
                val value2IsPercent = values[1].contains(PERCENTAGE)

                value1 = if (value1IsPercent) {
                    values[0].replace(PERCENTAGE, "").toDouble().percentage()
                } else {
                    values[0].toDouble()
                }

                value2 = if (value2IsPercent) {
                    values[1].replace(PERCENTAGE, "").toDouble().percentage()
                } else {
                    values[1].toDouble()
                }

                when (operation) {
                    PLUS -> if (value2IsPercent) value1 + value1 * value2 else value1 + value2
                    MINUS -> if (value2IsPercent) value1 - value1 * value2 else value1 - value2
                    MULTIPLY -> value1 * value2
                    DIVIDE -> value1 / value2
                    else -> 0.0
                }
            } else {
                values[0].replace(PERCENTAGE, "").toDouble().percentage()
            }

            clear()
            input.replace(0, input.length, result.asFormattedString())
        }

        return input.toString()
    }

    private fun clear(): String {
        value1 = 0.0
        value2 = 0.0
        operation = ""

        input.clear().append("0")
        return input.toString()
    }

    // region extensions
    private fun Double.percentage() = this.div(100.0)

    private fun Double.asFormattedString(): String {
        return DecimalFormat("0.#####").format(this).replace(",", ".")
    }
    // endregion

    private companion object {
        const val DIGITS = "0..9"
        const val DECIMAL_SEPARATOR = "."
        const val PLUS = "+"
        const val MINUS = "-"
        const val MULTIPLY = "*"
        const val DIVIDE = "/"
        const val PERCENTAGE = "%"
        const val INVERT_SIGNAL = "+/-"
        const val RESULT = "="
        const val CLEAR = "C"
        const val SQRT = "\u221A"
    }
}