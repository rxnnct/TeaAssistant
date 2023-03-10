package com.example.teaassistant.data.repository

import com.example.teaassistant.data.storage.SettingsStorage
import com.example.teaassistant.domain.models.settings.Language
import com.example.teaassistant.domain.models.settings.Settings
import com.example.teaassistant.domain.models.settings.SettingsSaveParam
import com.example.teaassistant.domain.repository.SettingsRepository
import com.example.teaassistant.data.storage.models.Settings as SettingsFromStorage

class SettingsRepositoryImpl(private val settingsStorage: SettingsStorage) : SettingsRepository {

    override fun saveSettings(saveParam: SettingsSaveParam): Boolean {

        val settings = SettingsFromStorage(
            language = saveParam.language.name
        )

        return settingsStorage.save(settings)
    }

    override fun getSettings(): Settings {
        val language = settingsStorage.get().language

        return Settings(language = Language.valueOf(language))
    }
}