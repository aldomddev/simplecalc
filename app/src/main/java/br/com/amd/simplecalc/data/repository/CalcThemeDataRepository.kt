package br.com.amd.simplecalc.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import br.com.amd.simplecalc.domain.repository.CalcThemeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CalcThemeDataRepository @Inject constructor(
    private val preferencesDataStore: DataStore<Preferences>
) : CalcThemeRepository {

    override suspend fun getDarkThemePreference(): Flow<Boolean> {
        return preferencesDataStore.data
            .catch {
                emit(emptyPreferences())
            }
            .map { preferences ->
                preferences[DARK_THEME_PREF] ?: false
            }
            .distinctUntilChanged()
    }

    override suspend fun saveThemePreference(darkTheme: Boolean) {
        try {
            preferencesDataStore.edit { preferences ->
                preferences[DARK_THEME_PREF] = darkTheme
            }
        } catch (error: Exception) {
            // TODO: log
        }
    }

    private companion object {
        val DARK_THEME_PREF = booleanPreferencesKey("dark_theme")
    }
}