package com.example.teaassistant.domain.repository

import com.example.teaassistant.domain.models.settings.Settings
import com.example.teaassistant.domain.models.settings.SettingsSaveParam

interface SettingsRepository {

    fun saveSettings(saveParam: SettingsSaveParam): Boolean

    fun getSettings(): Settings
}