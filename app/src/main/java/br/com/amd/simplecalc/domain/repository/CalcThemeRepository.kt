package br.com.amd.simplecalc.domain.repository

import kotlinx.coroutines.flow.Flow

interface CalcThemeRepository {
    suspend fun getDarkThemePreference(): Flow<Boolean>
    suspend fun saveThemePreference(darkTheme: Boolean)
}