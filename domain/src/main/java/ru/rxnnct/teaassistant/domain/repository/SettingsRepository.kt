package ru.rxnnct.teaassistant.domain.repository

import ru.rxnnct.teaassistant.domain.models.settings.Settings
import ru.rxnnct.teaassistant.domain.models.settings.SettingsSaveParam

interface SettingsRepository {

    fun saveSettings(saveParam: SettingsSaveParam): Boolean

    fun getSettings(): Settings
}