package br.com.amd.simplecalc.domain.usecase

import br.com.amd.simplecalc.domain.repository.CalcThemeRepository
import javax.inject.Inject

class SaveThemePreferenceUseCase @Inject constructor(
    private val calcThemeRepository: CalcThemeRepository
) {
    suspend operator fun invoke(darkTheme: Boolean) {
        calcThemeRepository.saveThemePreference(darkTheme)
    }
}