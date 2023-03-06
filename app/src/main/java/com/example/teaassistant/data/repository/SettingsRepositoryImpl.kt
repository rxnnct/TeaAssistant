package com.example.teaassistant.data.repository

import android.content.Context
import com.example.teaassistant.domain.models.Language
import com.example.teaassistant.domain.models.Settings
import com.example.teaassistant.domain.models.SettingsSaveParam
import com.example.teaassistant.domain.repository.SettingsRepository

private const val SHARED_PREFERENCES_NAME = "shared_preferences_name"
private const val KEY_LANGUAGE = "language"

class SettingsRepositoryImpl(context: Context) : SettingsRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun saveSettings(saveParam: SettingsSaveParam): Boolean {
        sharedPreferences.edit().putString(KEY_LANGUAGE, saveParam.language.toString()).apply()
        return true
    }

    override fun getSettings(): Settings {
        val language = sharedPreferences.getString(KEY_LANGUAGE, "") ?: ""
        return Settings(language = Language.valueOf(language))
    }
}