package br.com.amd.simplecalc.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.amd.simplecalc.domain.CalcProcessor
import br.com.amd.simplecalc.ui.model.KeyVO
import br.com.amd.simplecalc.ui.model.toKeyDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val calcProcessor: CalcProcessor
) : ViewModel() {

    private val _displayValue = mutableStateOf("0")
    val displayValue: State<String> = _displayValue

    fun onKeyPressed(keyVO: KeyVO) {
        _displayValue.value = calcProcessor.processKey(key = keyVO.label)
    }

    private fun processKeyPressed(keyValue: String) {
        // 1 - value or action
        when (keyValue) {
            CLEAR -> _displayValue.value = ""
            DIGITS -> {}
            PLUS -> {}
            MINUS -> {}
            MULTIPLY -> {}
            DIVIDE -> {}
            DECIMAL_SEPARATOR -> { /* ignore if input number already has a dot */ }
        }
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
