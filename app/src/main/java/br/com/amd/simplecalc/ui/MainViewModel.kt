package br.com.amd.simplecalc.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.amd.simplecalc.domain.CalcProcessor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val calcProcessor: CalcProcessor
) : ViewModel() {

    private val _darkTheme = mutableStateOf(true)
    val darkTheme: State<Boolean> = _darkTheme

    private val _displayValue = mutableStateOf("0")
    val displayValue: State<String> = _displayValue

    fun onChangeTheme(darkTheme: Boolean) {
        _darkTheme.value = darkTheme
    }

    fun onKeyPressed(key: String) {
        _displayValue.value = calcProcessor.processKey(key = key)
    }
}
