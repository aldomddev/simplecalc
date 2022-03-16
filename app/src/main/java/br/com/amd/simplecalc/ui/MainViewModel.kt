package br.com.amd.simplecalc.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.amd.simplecalc.domain.calc_processor.CalcProcessor
import br.com.amd.simplecalc.domain.usecase.IsDarkThemeEnabledUseCase
import br.com.amd.simplecalc.domain.usecase.SaveThemePreferenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val calcProcessor: CalcProcessor,
    private val isDarkThemeEnabledUseCase: IsDarkThemeEnabledUseCase,
    private val saveThemePreferenceUseCase: SaveThemePreferenceUseCase
) : ViewModel() {

    private val _darkTheme = mutableStateOf(false)
    val darkTheme: State<Boolean> = _darkTheme

    private val _displayValue = mutableStateOf("0")
    val displayValue: State<String> = _displayValue

    init {
        setThemeFromUserPreferences()
    }

    private fun setThemeFromUserPreferences() = viewModelScope.launch {
        isDarkThemeEnabledUseCase().collect { darkThemeEnabled ->
            _darkTheme.value = darkThemeEnabled
        }
    }

    fun onChangeTheme(darkTheme: Boolean) = viewModelScope.launch {
        saveThemePreferenceUseCase(darkTheme)
        _darkTheme.value = darkTheme
    }

    fun onKeyPressed(key: String) {
        _displayValue.value = calcProcessor.processKey(key = key)
    }
}
