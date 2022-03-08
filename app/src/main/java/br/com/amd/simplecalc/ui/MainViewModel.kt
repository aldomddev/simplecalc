package br.com.amd.simplecalc.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.amd.simplecalc.domain.CalcProcessor
import br.com.amd.simplecalc.ui.model.KeyVO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val calcProcessor: CalcProcessor
) : ViewModel() {

    private val _darkTheme = mutableStateOf(false)
    val darkTheme: State<Boolean> = _darkTheme

    private val _displayValue = mutableStateOf("0")
    val displayValue: State<String> = _displayValue

    fun onKeyPressed(keyVO: KeyVO) {
        _displayValue.value = calcProcessor.processKey(key = keyVO.label)
    }
}
