package ru.rxnnct.teaassistant.data.repository

import ru.rxnnct.teaassistant.data.storage.SettingsStorage
import ru.rxnnct.teaassistant.domain.models.settings.Language
import ru.rxnnct.teaassistant.domain.models.settings.Settings
import ru.rxnnct.teaassistant.domain.models.settings.SettingsSaveParam
import ru.rxnnct.teaassistant.domain.repository.SettingsRepository
import ru.rxnnct.teaassistant.data.storage.models.Settings as SettingsFromStorage

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