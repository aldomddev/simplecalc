package br.com.amd.simplecalc.domain

import androidx.core.text.isDigitsOnly
import java.text.DecimalFormat
import javax.inject.Inject

class CalcProcessorImpl @Inject constructor() : CalcProcessor {

    private var input = StringBuilder("0")

    private var value1: Double = 0.0
    private var value2: Double = 0.0
    private var operation: String = ""

    override fun processKey(key: String): String {
        // 1 - value or action
        return when {
            key == PLUS ||
            key == MINUS ||
            key == MULTIPLY ||
            key == DIVIDE -> appendArithmeticOperation(operation = key)
            key.isDigitsOnly() -> processDigit(digit = key)
            key == DECIMAL_SEPARATOR -> processDecimalSeparator()
            key == CLEAR -> clear()
            key == RESULT -> processResult()
            else -> input.toString()
        }
    }

    private fun processResult(): String {
        if (input.last().isDigit() && operation.isNotEmpty()) {
            val values = input.split(" $operation ")

            value1 = values[0].toDouble()
            value2 = values[1].toDouble()

            val result = when(operation) {
                PLUS -> value1 + value2
                MINUS -> value1 - value2
                MULTIPLY -> value1 * value2
                DIVIDE -> value1 / value2
                else -> 0.0
            }

            clear()
            val resultString = DecimalFormat("0.#####").format(result).replace(",", ".")
            input.replace(0, input.length, resultString)
        }

        return input.toString()
    }

    private fun processDigit(digit: String): String {
        if (input.toString() == "0") {
            input[0] = digit[0]
        } else {
            input.append(digit)
        }
        return input.toString()
    }

    private fun processDecimalSeparator(): String {
        if(!input.contains(DECIMAL_SEPARATOR)) {
            input.append(DECIMAL_SEPARATOR)
        }

        return input.toString()
    }

    private fun clear(): String {
        value1 = 0.0
        value2 = 0.0
        operation = ""

        input.clear()
        input.append("0")
        return input.toString()
    }

    private fun appendArithmeticOperation(operation: String): String {
        if (this.operation.isNotEmpty()) return input.toString()
        this.operation = operation

        if (input.contains(Regex.fromLiteral("\\s[\\+\\-\\*\\/]{1}\$"))) {
            input.insert(input.length - 1, operation)
        } else {
            input.append(" ".plus(operation).plus(" "))
        }

        return input.toString()
    }

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
    }
}