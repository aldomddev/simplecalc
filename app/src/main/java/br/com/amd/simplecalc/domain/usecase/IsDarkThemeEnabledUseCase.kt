package br.com.amd.simplecalc.domain.usecase

import br.com.amd.simplecalc.domain.repository.CalcThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsDarkThemeEnabledUseCase @Inject constructor(
    private val calcThemeRepository: CalcThemeRepository
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return calcThemeRepository.getDarkThemePreference()
    }
}